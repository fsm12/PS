import java.io.*;
import java.util.*;

public class Main {
    static int N, sharkSize = 2, numberOfEating = 0, move = 0;
    static int[] cur, dx={-1,0,1,0}, dy={0,-1,0,1};
    static int[][] map;
    static boolean[][] vis;
    static boolean ck;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream(input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            vis = new boolean[N][N];

            que.add(new int[]{cur[0], cur[1], 0});
            vis[cur[0]][cur[1]] = true;

            ck = false;

            while (!que.isEmpty()) {
                cur = que.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < sharkSize) { 
                    map[cur[0]][cur[1]] = 0; 
                    numberOfEating++;
                    move += cur[2]; 
                    ck = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || vis[ny][nx] || map[ny][nx] > sharkSize)
                        continue;

                    que.add(new int[]{ny, nx, cur[2] + 1});
                    vis[ny][nx] = true;
                }
            }

            if (!ck)
                break;

            if (sharkSize == numberOfEating) {
                sharkSize++;
                numberOfEating = 0;
            }
        }
        System.out.println(move);
    }
}