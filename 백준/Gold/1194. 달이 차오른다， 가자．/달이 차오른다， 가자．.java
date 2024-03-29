import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static int N,M,ans=Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][][] vis;
	static Queue<int[]> q; // x,y,move,keys
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        q = new LinkedList<>();
        for(int n=0; n<N; n++) {
        	String inp = br.readLine();
        	for(int m=0; m<M; m++) {
        		map[n][m] = inp.charAt(m);
        		if(map[n][m] == '0') {
        			q.add(new int[] {n,m,0,0});
        		}
        	}
        }
        System.out.println(bfs());
    }
    
    public static int bfs() {

        vis = new boolean[N][M][64];
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	int curMove = cur[2];
        	int curKey = cur[3];
        	
        	// 2. 목적지 - '1'을 만날 때
        	if(map[cur[0]][cur[1]]=='1') {
        		return curMove;
        	}
        	
        	// 3. 연결되어 있는가 - 4방
        	for(int i=0; i<4; i++) {
        		int nx = cur[0] + dx[i];
        		int ny = cur[1] + dy[i];
        		
        		// 4. 갈 수 있는가
        		// 4-1. 맵안
        		if(0<=nx && nx<N && 0<=ny && ny<M) {        			
        			// 4-2. 방문 했거나 벽이면 pass
        			if(map[nx][ny]=='#' || vis[nx][ny][curKey]) {
        				continue;
        			}
        			
        			// 4-3. 현재 칸이 방의 문이고
        			if('A'<=map[nx][ny] && map[nx][ny]<='F') {
        				// 나는 맞는 열쇠를 가지고 있는 경우
        				if(0 < ((1 << (map[nx][ny]-'A')) & curKey)) {
            				vis[nx][ny][curKey] = true;
            				q.add(new int[] {nx,ny,curMove+1,curKey});
            			}
        				continue;
        			}
        			
        			// 4-4. 현재 칸이 열쇠일 경우, 추가
        			if('a'<=map[nx][ny] && map[nx][ny]<='f') {
        				int addKey = 1 << (map[nx][ny]-'a') | curKey;
        				if(!vis[nx][ny][addKey]) {
            				vis[nx][ny][addKey] = true;
            				vis[nx][ny][curKey] = true;
            				q.add(new int[] {nx,ny,curMove+1,addKey});
            				continue;
        				}
        			}
        			
        			// 4-5. 나머지는 갈 수 있는 노드로 추가
    				vis[nx][ny][curKey] = true;
    				q.add(new int[] {nx,ny,curMove+1,curKey});
        		}
        	}
        }
        return -1;
    }
}