import java.io.*;
import java.util.*;

public class Main {
	static int N,M,r,c,ans=0;
	static char[][] campus;
	static boolean[][] vis;
	static int[] dx = {-1,1,0,0}, dy= {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        campus = new char[N][M];
        vis = new boolean[N][M];
        for(int n=0; n<N; n++) {
        	String inp = br.readLine();
        	for(int m=0; m<M; m++) {
        		campus[n][m] = inp.charAt(m);
        		if(campus[n][m]=='I') {
        			r=n;
        			c=m;
        		}
        	}
        }
        dfs(r,c);
        System.out.println(ans==0?"TT":ans);
    }
    
    public static void dfs(int x, int y) {
    	vis[x][y] = true;
    	if(campus[x][y] == 'P')
    		ans++;
    	for(int i=0; i<4; i++) {
    		int nx = x+dx[i];
    		int ny = y+dy[i];
    		if(0<=nx && nx<N && 0<=ny && ny<M && !vis[nx][ny]) {
    			if(campus[nx][ny] != 'X')
    	    		dfs(nx,ny);
    		}
    	}
    }
}