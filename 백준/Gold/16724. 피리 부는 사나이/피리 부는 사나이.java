import java.io.*;
import java.util.*;

public class Main {
    static int N,M,cnt=0,step=1;
    static String[] map;
    static int[][] vis;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int dir(char c) {
        switch (c) {
            case 'U': return 0;
            case 'D': return 1;
            case 'L': return 2;
            case 'R': return 3;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];
        for (int n = 0; n < N; n++)
            map[n] = br.readLine();

        vis = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (vis[n][m] == 0) {
                    int x = n;
                    int y = m;
                    while (vis[x][y] == 0) {
                        vis[x][y] = step;
                        x += dx[dir(map[x].charAt(y))];
                        y += dy[dir(map[x].charAt(y))];
                    }
                    if (vis[x][y] == step)
                        cnt++;
                }
                step++;
            }
        }
        System.out.println(cnt);
    }
}