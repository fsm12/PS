import java.util.*;
import java.io.*;

public class Main{
	static int R,C,nx,ny,ans=-1;
	static char[][] map;
	static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	static Queue<int[]> fq, jq;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		fq = new LinkedList<>();
		jq = new LinkedList<>();
		
		int[][] fVis = new int[R][C];
		int[][] jVis = new int[R][C];
		
		for(int r=0; r<R; r++) {
			String inp = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = inp.charAt(c);
				if(map[r][c] == 'J') {
					jq.add(new int[] {r,c});
					jVis[r][c] = 1;
				}
				if(map[r][c] == 'F') {
					fq.add(new int[] {r,c});
					fVis[r][c] = 1;
				}
			}
		}

		// 불 이동 - fVis에 해당 칸에 불이 퍼지기 위한 시간 저장
		while(!fq.isEmpty()) {
			int[] curPos = fq.poll();
			
			for(int i=0; i<4; i++) {
				nx = curPos[0]+dx[i];
				ny = curPos[1]+dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C && fVis[nx][ny]==0 && map[nx][ny] != '#') {
					fq.add(new int[] {nx,ny});
					fVis[nx][ny] = fVis[curPos[0]][curPos[1]]+1;
				}
			}
		}
		
		// 지훈 이동 - 불이 없고, 벽이 아니고, 맵 밖을 갈 수 있음(탈출)
		exit : while(!jq.isEmpty()) {
			int[] curPos = jq.poll();
			if(curPos[0]<0 || R<=curPos[0] || curPos[1]<0 || C<=curPos[1]) {
				ans = curPos[0];
				break;
			}
				
			for(int i=0; i<4; i++) {
				nx = curPos[0]+dx[i];
				ny = curPos[1]+dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C && jVis[nx][ny]==0 && (fVis[nx][ny]==0 || jVis[curPos[0]][curPos[1]]+1 < fVis[nx][ny]) 
						&& map[nx][ny] != '#' && map[nx][ny] != 'F' && map[nx][ny] == '.'){
					jq.add(new int[] {nx,ny});
					jVis[nx][ny] = jVis[curPos[0]][curPos[1]]+1;
				}
				
				if(nx<0 || R<=nx || ny<0 || C<=ny) {
					ans = jVis[curPos[0]][curPos[1]];
					break exit;
				}
			}
		}
		System.out.println(ans==-1?"IMPOSSIBLE":ans);
	}
}
