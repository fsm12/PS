import java.util.*;
import java.io.*;

public class Main{
	static int N,M,cnt,ans;
	static boolean[][] map, vis;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken())== 1;
			}
		}

		cnt = 0;
		ans = 0;
		vis = new boolean[N][M];
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(!vis[n][m] && map[n][m]) {
					vis[n][m] = true;
					ans = Math.max(ans, bfs(n,m));
					cnt+=1;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(ans);
	}
	
	public static int bfs(int x, int y) {
		int size = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			
			int nx,ny;
			for(int i=0; i<4; i++) {
				nx = xy[0]+dx[i];
				ny = xy[1]+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(!vis[nx][ny] && map[nx][ny]){
					    q.add(new int[] {nx, ny});
					    vis[nx][ny] = true;
					    size +=1;
                    }
				}
			}
		}
		return size;
	}
}