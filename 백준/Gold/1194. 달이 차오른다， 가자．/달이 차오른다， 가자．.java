import java.util.*;
import java.io.*;

/*
 * 
// [ 변수선언 ] 

// 기본 맵 : board[N][M]
// 방문처리 : vis[N][M][128]

// 0 위치를 찾아서 큐에 넣는다.

// bfs
// 큐에 넣는다.
while(!q.isEmpty()){
	// 큐에서 하나를 뺀다.
    // 목적지인가? (1인가)
    	// 최솟값 저장 후 바로 나간다.
    // 연결되어 있는가 (상하좌우 한칸씩)
        // 갈 수 있는가 (방문하지 않았고, 맵안이고, 벽이 아니고, 문이라면 열쇠를 가졌다.)
             // 큐에 담는다.
             // 방문처리한다.

}
 */

public class Main{
	static int N,M,ans;
	static char[][] board;
	static boolean[][][] vis;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		vis = new boolean[N][M][128];
		
		Queue<Pos> q = new LinkedList<>();
		
		for(int n=0; n<N; n++) {
			String inp = br.readLine();
			for(int m=0; m<M; m++) {
				board[n][m] = inp.charAt(m);
				if(board[n][m] == '0') {
					q.add(new Pos(n,m,0,0));
					vis[n][m][0] = true;
				}
			}
		}
		
		ans = -1;
		while(!q.isEmpty()) {
			// 큐에서 하나를 뺀다.
			Pos cur = q.poll();
		    int cx = cur.x;
		    int cy = cur.y;
		    int cVis = cur.vis;
		    int cWalk = cur.walk;
			
			// 목적지인가? (1인가)
		    if(board[cx][cy] == '1') {
		    	// 최솟값 저장 후 바로 나간다.
		    	ans = cWalk;
		    	break;
		    }
		    
		    // 연결되어 있는가 (상하좌우 한칸씩)
		    for(int i=0; i<4; i++) {
		    	int nx = cx+ dx[i];
		    	int ny = cy+ dy[i];
		    	int nVis = cVis;
		    	int nWalk = cWalk;
		    	
		        // 갈 수 있는가
		    	// 맵안이고, 벽이 아니고,
		    	if(0<=nx && nx<N && 0<=ny && ny<M && board[nx][ny] != '#') {
		    		// 지금 위치가 열쇠라면 
		    		if('a'<=board[nx][ny] && board[nx][ny]<='f') {
		    			// vis 계산하기
		    			// nVis = 1<<(6-(board[nx][ny]-'a')) | cVis;
		    			nVis = (1<<(5-(board[nx][ny]-'a'))) | cVis;
		    		}
		    		
		    		// 방문하지 않았고,
		    		if(!vis[nx][ny][nVis]) {
		    			// 문이라면 열쇠를 가져야만 지나갈 수 있다.
		    			// 현재 가지고 있는 열쇠는 nVis, 문은 board[nx][ny] - 'A'
		    			// 1<<(5-(board[nx][ny] - 'A') 연산을 하면 그 위치만 1임
		    			if('A'<=board[nx][ny] && board[nx][ny]<='F') {
			    			int std = 1<<(5-(board[nx][ny] - 'A'));
		    				
			    			if(std == (std&nVis)) {
				    			// 큐에 담는다.
				    			q.add(new Pos(nx, ny, nVis, nWalk+1));
			    				// 방문처리한다.
				    			vis[nx][ny][nVis] = true;
		    				}
		    			}
		    			
		    			// 문이 아니라면 
		    			if('A'>board[nx][ny] || board[nx][ny]>'F') {
		    				// 큐에 담는다.
			    			q.add(new Pos(nx, ny, nVis, cWalk+1));
		    				// 방문처리한다.
			    			vis[nx][ny][nVis] = true;
		    			}
		    		}
		    	}
		    }
		}
		System.out.println(ans);
	}
}

class Pos{
	int x;
	int y;
	int vis;
	int walk;
	
	public Pos(int x, int y, int vis, int walk) {
		this.x=x;
		this.y=y;
		this.vis = vis;
		this.walk = walk;
	}
}