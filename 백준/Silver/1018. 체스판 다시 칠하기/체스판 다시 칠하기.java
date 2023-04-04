import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> N M (N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수)
 * N> 보드의 각 행의 상태 (B는 검은색이며, W는 흰색)
 * => 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값
 * 
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 
 * 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다
 * 
 */

public class Main{
	static int N,M,min=Integer.MAX_VALUE;
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		map = new boolean[N][M];
		for (int n = 0; n < N; n++) {
			String tmp = br.readLine();
			for (int m = 0; m < M; m++) {
				if (tmp.charAt(m) == 'W') {
					map[n][m] = true;	
				} else {
					map[n][m] = false;	
				}
			}
		}
 
		for (int n = 0; n < N-7; n++) {
			for (int m = 0; m < M-7; m++) {
				int idx_w = 0; // W로 시작할 경우
				int idx_b = 0; // B로 시작할 경우
				for (int i=n; i<n+8; i++) {
					for(int j=m; j<m+8; j++) {
						if ((i+j)%2 == 0) { // 시작점의 색깔과 같은 색
							if(map[i][j])
								idx_b+=1;
							else
								idx_w+=1;		
						}else { // 시작점의 색깔과 다른 색
							if(map[i][j]) 
								idx_w+=1;
							else
								idx_b+=1;	
						}
					}
				}
				min = Math.min(min, Math.min(idx_w, idx_b));
			}
		}
		System.out.println(min);
	}
}