import java.util.*;
import java.io.*;

public class Main {
	static int N,M,max,moveCnt=0;
	static int[][] map, dp;
	static boolean[][] vis;
	static boolean flag= false;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp =  new int[N][M];
		vis = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if(line[j].equals("H")) {
					map[i][j] = -1; // hole = -1
				}else {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}
		}
		
		dfs(0,0,1);
		System.out.println(flag?-1:max);

	}

	private static void dfs(int x, int y, int moveCnt) {
		//System.out.println("x,y : "+x+" "+y);
		if(moveCnt>max) {
			max = moveCnt;
		}
		dp[x][y] = moveCnt;
		//3.연결된 곳을 순회 : 상하좌우
		for(int i=0; i<4; i++) {
			int curVal = map[x][y];
			int calX = x+dx[i]*curVal;
			int calY = y+dy[i]*curVal;
			//2.목적지인가 : 구멍을 만났는가 + 4.갈수 있는가 : 맵 안에 있는가
			if(0<=calX && calX<N && 0<=calY && calY<M && map[calX][calY] != -1) {
				//2.목적지인가 : 방문한 곳을 다시 방문하였는가
				if(vis[calX][calY]) {
					flag = true;
					return;
				}
				if(dp[calX][calY] > moveCnt) continue;
				//1.체크인 : 방문중 처리
				vis[x][y] = true;
				//5.간다
				dfs(calX,calY,moveCnt+1);
				//6.체크아웃 : 방문완료 처리
				vis[x][y] = false;
			}	
		}	
	}
}