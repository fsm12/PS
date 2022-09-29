import java.util.*;
import java.io.*;

public class Main{
    static int N, ans=Integer.MAX_VALUE;
    static List<Point> points;
    static int[][] vis;
    static int[] dx = {-2,-2,0,0,2,2}, dy = {-1,1,-2,2,-1,1};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        points = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            points.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        vis = new int[N][N];

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(points.get(0).x, points.get(0).y));
        vis[points.get(0).x][points.get(0).y] = 1;

        while(!q.isEmpty()){
            //1. 큐에서 꺼내옴
            Point p = q.remove();
            //2. 목적지인가
            if(p.x==points.get(1).x && p.y==points.get(1).y){
                break;
            }
            //3. 연결되어있는가
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                //4. 갈수있는가
                if(0<=nx && nx<N && 0<=ny && ny<N && vis[nx][ny]==0){
                    //5. 체크인
                    vis[nx][ny] = vis[p.x][p.y]+1;
                    //6. 큐에넣음
                    q.add(new Point(nx, ny));
                }
            }
        }
        System.out.println(vis[points.get(1).x][points.get(1).y] - 1);
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