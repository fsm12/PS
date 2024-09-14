import java.io.*;
import java.util.*;

public class Solution {
    static int N, K, maxLen;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];
            maxLen = 0;

            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + maxLen);
        }
    }

    static void dfs(int x, int y, int length, boolean cutUsed) {
        maxLen = Math.max(maxLen, length);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                continue;
            }

            if (map[nx][ny] < map[x][y]) {
                visited[nx][ny] = true;
                dfs(nx, ny, length + 1, cutUsed);
                visited[nx][ny] = false;
            } else if (!cutUsed && map[nx][ny] - K < map[x][y]) {
                int originalHeight = map[nx][ny];
                map[nx][ny] = map[x][y] - 1;
                visited[nx][ny] = true;
                dfs(nx, ny, length + 1, true);
                visited[nx][ny] = false;
                map[nx][ny] = originalHeight;
            }
        }
    }
}
