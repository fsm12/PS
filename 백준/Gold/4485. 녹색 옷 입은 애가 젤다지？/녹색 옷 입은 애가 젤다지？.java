import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static int[][] map, rupeeMap;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            rupeeMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    rupeeMap[i][j] = Integer.MAX_VALUE;
                }
            }
            rupeeMap[0][0] = map[0][0];
            bfs();
            System.out.println("Problem " + t + ": " + rupeeMap[N - 1][N - 1]);
            t++;
        }
    }

    private static void bfs() {
        Deque<Pos> queue = new ArrayDeque<>();
        queue.add(new Pos(0, 0));
        while (!queue.isEmpty()) {
            int nx, ny;
            Pos pos = queue.poll();
            int x = pos.x;
            int y = pos.y;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (!isRange(nx, ny))
                    continue;
                if (rupeeMap[nx][ny] <= rupeeMap[x][y] + map[nx][ny])
                    continue;
                rupeeMap[nx][ny] = rupeeMap[x][y] + map[nx][ny];
                queue.add(new Pos(nx, ny));
            }
        }
    }
    private static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N ? false : true;
    }
}
class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}