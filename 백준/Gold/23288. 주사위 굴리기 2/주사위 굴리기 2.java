import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int[][] dice
            = {{0,2,0,0},   //  0  뒤  0  0
            {4,1,3,6},      // 좌측 위 우측 밑
            {0,5,0,0},      //  0  앞  0  0
            {0,6,0,0}};     //  0  밑  0  0
    static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        int x = 0;
        int y = 0;
        int d = 0;
        int ans = 0;
        // 이동횟수만큼만 이동
        while (K-- > 0) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 맵안이 아니라면
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                // 방향 바꿔줘야함 : [0은 상, 1은 우, 2는 하, 3은 좌] 이므로 반대방향과 2차이
                d = (d + 2) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            moveDice(dice, d);

            vis = new boolean[N][M];
            vis[nx][ny] = true;
            int cnt = dfs(nx, ny, map[nx][ny]);
            ans += cnt * map[nx][ny];

            int A = dice[3][1]; // 주사위의 밑면
            int B = map[nx][ny]; // 해당 위치의 점수

            // A>B이면 시계방향
            if (A > B) {
                d = (d + 1) % 4;
            }
            // A<B이면 반시계방향
            else if (A < B) {
                d = (d + 3) % 4;
            }

            x = nx;
            y = ny;
        }
        System.out.println(ans);
    }

    private static int dfs(int x, int y, int num) {
        int cnt = 1;
        // 1. 연결되어있는가
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 2-1. 갈수있는가 - 맵 안
            if (0<=nx && nx<N && 0<=ny && ny<M && !vis[nx][ny]) {
                // 2-2. 갈수있는가 - 같은 값
                if(map[nx][ny] == num){
                    vis[nx][ny] = true;
                    cnt += dfs(nx, ny, num);
                }
            }
        }
        return cnt;
    }

    private static void moveDice(int[][] dice, int direction) {
        int tmp=0;
        switch (direction) {
            case 0: // 동 -> dice[1][]을 한칸씩 좌측으로 옮기고 가장 좌측의 아이를 우측에 넣음
                tmp = dice[1][3];
                for (int i = 3; i > 0; i--) {
                    dice[1][i] = dice[1][i - 1];
                }
                dice[1][0] = tmp;
                dice[3][1] = dice[1][3];
                break;

            case 1 : // 서 -> dice[][1]을 한칸씩 우측으로 옮기고 가장 우측의 아이를 좌측에 넣음
                tmp = dice[3][1];
                for (int i = 3; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }
                dice[0][1] = tmp;
                dice[1][3] = dice[3][1];
                break;
            case 2 : // 남 -> dice[][1]을 한칸씩 위로 옮기고 가장 위의 아이를 밑에 넣음
                tmp = dice[1][0];
                for (int i = 0; i < 3; i++) {
                    dice[1][i] = dice[1][i + 1];
                }
                dice[1][3] = tmp;
                dice[3][1] = dice[1][3];
                break;
            case 3 : // 북 -> dice[][1]을 한칸씩 밑으로 옮기고 가장 밑의 아이를 위에 넣음
                tmp = dice[0][1];
                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }
                dice[3][1] = tmp;
                dice[1][3] = dice[3][1];
                break;
        }
    }
}