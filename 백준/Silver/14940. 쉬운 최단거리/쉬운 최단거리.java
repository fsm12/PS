import java.io.*;
import java.util.*;

public class Main {
    static int N,M,x,y;
    static int[][] map;
    static boolean[][] vis;
    static Queue<int[]> q;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        q = new LinkedList<>();
        map = new int[N][M];
        vis = new boolean[N][M];
        for(int n=0; n<N; n++) {
        	st = new StringTokenizer(br.readLine());
        	for(int m=0; m<M; m++) {
        		map[n][m] = Integer.parseInt(st.nextToken());
        		if(map[n][m] == 0) {
        			vis[n][m] = true;
        		}
        		if(map[n][m] == 2) {
        	        q.add(new int[] {n,m});
        	        map[n][m] = 0;
        	        vis[n][m] = true;
        		}
        	}
        }
        
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	int x = cur[0], y = cur[1];
        	for(int i=0; i<4; i++) {
        		int nx = x+dx[i], ny = y+dy[i];
        		if(0<=nx && nx<N && 0<=ny && ny<M) {
        			if(!vis[nx][ny]) {
	        			q.add(new int[] {nx, ny});
	        			map[nx][ny] = map[x][y]+1;
	        			vis[nx][ny] = true;
        			}
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++) {
        	for(int m=0; m<M; m++) {
        		if(!vis[n][m])
        			sb.append(-1);
        		else
        			sb.append(map[n][m]);
        		sb.append(" ");
        	}
        	sb.append("\n");
        }
        System.out.print(sb.toString());
        
    }
}