import java.util.*;
import java.io.*;

public class Main{
    static int T, M, N, K, cnt;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static int[][] map;
    static boolean[][] vis;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T-->0) {
            cnt=0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // 가로
            N = Integer.parseInt(st.nextToken());   // 세로
            K = Integer.parseInt(st.nextToken());   // 배추 위치

            map = new int[M][N];
            vis = new boolean[M][N];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if(map[m][n] == 1 && !vis[m][n]){
                        bfs(new Node(m, n));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(Node xy){
        q = new LinkedList<Node>();
        q.add(xy);
        while(!q.isEmpty()) {
            //1. 큐에서 꺼내옴
            int x = q.peek().x;
            int y = q.peek().y;
            vis[x][y] = true;
            q.poll();
            //3. 연결된 곳을 순회 : 4방
            for (int direct = 0; direct < 4; direct++) {
                int cx = x + dx[direct];
                int cy = y + dy[direct];
                //4. 갈 수 있는가? : 맵 안에 있고, 방문한 적이 없고, 1이라면
                if(cx >= 0 && cy >= 0 && cx < M && cy < N) {
                    if (!vis[cx][cy] && map[cx][cy] == 1) {
                        //5. 체크인 : vis
                        vis[cx][cy] = true;
                        //6. 큐에 넣음
                        q.add(new Node(cx, cy));
                    }
                }
            }
        }
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}