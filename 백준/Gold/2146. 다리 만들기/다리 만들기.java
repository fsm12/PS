import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] vis;
    static int N;
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};
    static int landNum = 2;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        vis = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) {
                    makeLand(r, c);
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] >= 2) {
                    vis = new boolean[N][N];
                    bfs(r, c);
                }
            }
        }
        System.out.println(answer);
    }

    private static void makeLand(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        vis[r][c] = true;
        map[r][c] = landNum;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((0<=r2 && r2<N && 0<=c2 && c2<N) && !vis[r2][c2] && map[r2][c2] == 1) {
                    vis[r2][c2] = true;
                    map[r2][c2] = landNum;
                    queue.offer(new Point(r2, c2, 0));
                }
            }
        }
        landNum++;
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(r, c, 0));
        int currentLandNum = map[r][c];
        vis[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < N && c2 >= 0 && c2 < N) && !vis[r2][c2] && map[r2][c2] != currentLandNum) { //방문안하고 바다 혹은 다른 섬인 경우
                    vis[r2][c2] = true;
                    if (map[r2][c2] == 0) {
                        queue.offer(new Point(r2, c2, point.cnt + 1));
                    } else { 
                        answer = Math.min(answer, point.cnt);
                    }
                }
            }
        }
    }

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}