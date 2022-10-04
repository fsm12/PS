import java.io.*;
import java.util.*;

public class Main {
    static int N,L,R,sum=0,days=0;
    static boolean isMove = false;
    static final int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static List<Point> union = new ArrayList<>();
    static boolean[][] vis;
    static int[][] map;

    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1 loop = 1 days
        while(true) {
            isMove = false;
            vis = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0;j<N; j++) {
                    if(!vis[i][j]){
                        BFS(i,j);
                    }
                }
            }
            // 위 완탐동안 진행한 곳이 없다면 break
            if(!isMove) break;
            else days++;
        }
        System.out.println(days);
    }

    static void BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        vis[x][y] = true;
        union.add(new Point(x,y));

        while(!q.isEmpty()) {
            Point node = q.poll();

            for(int k=0; k<4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if(0<=nx && nx<N && 0<=ny && ny<N && !vis[nx][ny]) {
                    if(L <= Math.abs(map[node.x][node.y] - map[nx][ny]) &&  Math.abs(map[node.x][node.y] - map[nx][ny]) <= R) {
                        isMove = true;
                        vis[nx][ny] = true;
                        q.add(new Point(nx,ny));
                        // 영역 더하기 위함
                        union.add(new Point(nx,ny));
                    }
                }
            }
        }

        sum=0;
        for (Point p : union) {
            sum += map[p.x][p.y];
        }

        for(int i=0; i<union.size(); i++) {
            Point p = union.get(i);
            map[p.x][p.y] = sum / union.size();
        }
        union = new ArrayList<>();
    }
}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}