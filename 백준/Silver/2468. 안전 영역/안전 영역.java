import java.io.*;
import java.util.*;

public class Main {
	static int N,min=100,max=0,ans=1;
	static int[][] map;
	static boolean[][] vis;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		for(int h=min; h<max; h++) {
			int curAns = 0;
			vis = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!vis[i][j] && h<map[i][j])
						curAns+=dfs(i,j,h);
				}
			}
			ans = Math.max(ans, curAns);
		}
		System.out.println(ans);
    }
	
	public static int dfs(int x, int y, int height) {
		vis[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N && !vis[nx][ny] && height < map[nx][ny]) {
				dfs(nx,ny, height);
			}
		}
		return 1;
	}
}