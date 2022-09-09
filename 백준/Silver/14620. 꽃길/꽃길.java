import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N, answer = Integer.MAX_VALUE;
    static int[] dx = {0, -1, 1, 0, 0}, dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<(N*N); i++) {
            for (int j=0; j<(N*N); j++) {
                for (int k=0; k<(N*N); k++) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(k);
                    answer = Math.min(answer, DFS(list));
                }
            }
        }
        System.out.println(answer);
    }

    static int DFS(ArrayList<Integer> list) {
        boolean[][] check = new boolean[N][N];

        int result = 0;
        for (int i: list) {
            int x = i / N;
            int y = i % N;

            if (x==0 || x==(N-1) || y==0 || y==(N-1)) {
                return Integer.MAX_VALUE;
            }

            for (int j=0; j<5; j++) {
                if (!check[x+dx[j]][y+dy[j]]) {
                    check[x+dx[j]][y+dy[j]] = true;
                    result += map[x+dx[j]][y+dy[j]];
                }
                else return Integer.MAX_VALUE;
            }
        }
        return result;
    }
}