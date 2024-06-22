import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[N][M];
        int[][] wolf = new int[N * M][2];
        int wCnt = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '.') map[i][j] = 'P';  
                else {
                    if (line.charAt(j) == 'W') wolf[wCnt++] = new int[]{i, j};
                    map[i][j] = line.charAt(j);
                }
            }
        }

        for (int i = 0; i < wCnt; i++) {
            Queue<int[]> q = new LinkedList<>();
            q.add(wolf[i]);

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    int currY = curr[0] + dy[j];
                    int currX = curr[1] + dx[j];
                    if (isValid(currY, currX) && !visited[currY][currX]) {
                        char c = map[currY][currX];
                        if (c != '#') {
                            if (c == 'P') map[currY][currX] = '.';
                            else if (c == '+') {
                                while (isValid(currY + dy[j], currX + dx[j])
                                        && map[currY][currX] == '+'
                                        && map[currY + dy[j]][currX + dx[j]] != '#') {
                                    currY += dy[j];
                                    currX += dx[j];
                                }
                                if (map[currY][currX] == 'P') map[currY][currX] = '.';
                            }

                            if (!visited[currY][currX]) {
                                visited[currY][currX] = true;
                                q.add(new int[]{currY, currX});
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(map[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    static boolean isValid(int y, int x) {
        return y >= 1 && y < N - 1 && x >= 1 && x < M - 1;
    }
}