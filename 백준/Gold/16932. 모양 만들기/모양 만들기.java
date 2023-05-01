import java.util.*;
import java.io.*;

/* bfs
 * 맵에 1값을 가지는 구역별로 2,3.. 으로 구간 나누기 (해시맵으로 저장)
 * 0값을 가진 좌표들을 미리 저장하고 이를 순회하며
 *   저장해둔 구역번호로 vis set을 확인하면서 구역 max값 찾기 
 */

public class Main{
	static int N,M,ck=1,max;
	static int[][] grid;
	static List<Point> zero;
	static Set<Integer> vis;
	static Map<Integer, Integer> map;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		zero = new ArrayList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				grid[n][m] = Integer.parseInt(st.nextToken());
				if(grid[n][m] == 0) {
					zero.add(new Point(n,m));
				}
					
			}
		}
		
		map = new HashMap<>();
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(grid[n][m]==1) {
					makeShape(new Point(n,m));
				}
			}
		}
		
        for(Point z :zero) {
    		vis = new HashSet<>();
        	int size = 1;
        	for(int i=0; i<4; i++) {
                int nx = z.x + dx[i];
                int ny = z.y + dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M && grid[nx][ny] != 0 && !vis.contains(grid[nx][ny])) {
	                vis.add(grid[nx][ny]);
	                size += map.get(grid[nx][ny]);
	            }
            }
            max = Math.max(max, size);
        }
        bw.append(max+"");
        bw.flush();
	}
	
	public static void makeShape(Point p) {
		ck+=1;
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		grid[p.x][p.y] = ck;
		int cnt=1;
		
		while(!q.isEmpty()) {
			Point node = q.poll();
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M && grid[nx][ny]==1) {
					q.add(new Point(nx,ny));
					grid[nx][ny] = ck;
					cnt+=1;
				}
			}
		}
		map.put(ck, cnt);
	}
	
	static class Point{
		int x,y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}