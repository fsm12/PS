import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		dp = new int[3][N];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++) {
				dp[i][n] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<N; i++) {
			dp[0][i] += Math.min(dp[1][i-1], dp[2][i-1]);
			dp[1][i] += Math.min(dp[0][i-1], dp[2][i-1]);
			dp[2][i] += Math.min(dp[0][i-1], dp[1][i-1]);
		}
		
		bw.append(String.valueOf(Math.min(dp[0][N-1], Math.min(dp[1][N-1], dp[2][N-1]))));
		bw.flush();
	}
}