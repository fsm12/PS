import java.io.*;
import java.util.*;

public class Main {
    static int N, M, groupNumber;
    static int[][] dist;
    static int[] check;
    static PriorityQueue<Integer> representation;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        check = new int[N + 1];
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dist[x][y] = dist[y][x] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE || i == j)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (check[i] != 0) continue;
            groupNumber++;
            dfs(i);
        }

        representation = new PriorityQueue<>();
        for (int i = 1; i <= groupNumber; i++) {
            representation.add(getGroupRepresentation(i));
        }

        System.out.println(groupNumber);
        while (!representation.isEmpty()) {
            System.out.println(representation.poll());
        }
    }

    private static int getGroupRepresentation(int groupNumber) {
        int min_sum = Integer.MAX_VALUE, sum, representation = 0;

        for (int i = 1; i <= N; i++) {
            if (check[i] != groupNumber) continue;
            sum = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    continue;
                sum = Math.max(sum, dist[i][j]);
            }
            if (min_sum > sum) {
                min_sum = sum;
                representation = i;
            }
        }
        return representation;
    }

    private static void dfs(int start) {
        if (check[start] != 0)
            return;
        check[start] = groupNumber;

        for (int i = 1; i <= N; i++) {
            if (dist[start][i] == 0 || dist[start][i] == Integer.MAX_VALUE)
                continue;
            dfs(i);
        }
    }
}