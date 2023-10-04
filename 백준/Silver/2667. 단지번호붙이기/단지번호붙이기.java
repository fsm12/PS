import java.io.*;
import java.util.*;

public class Main {
	static int N,numberOf=0,total=0;
	static List<Integer> sortedList;
	static int[][] map;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String inp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(inp.charAt(j)));
			}
		}
		
		sortedList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					total+=1;
					numberOf = 0;
					bfs(i,j);
					sortedList.add(numberOf==0?1:numberOf);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(total).append("\n");
		Collections.sort(sortedList);
		for(int i=0; i<sortedList.size(); i++) {
			sb.append(sortedList.get(i)).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cx = cur.x, cy = cur.y;
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i], ny = cy + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<N && map[nx][ny] == 1) {
					q.add(new Point(nx,ny));
					map[nx][ny] = 0;
					numberOf+=1;
				}
			}
		}
	}
}

class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}