import java.io.*;
import java.util.*;

public class Main{
	static int N,M,K;
	static int[][] dp, map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m=1; m<=M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n=1; n<=N; n++) {
			for(int m=1; m<=M; m++) {
				dp[n][m] = map[n][m] + dp[n-1][m] + dp[n][m-1] - dp[n-1][m-1];
			}
		}
		
		K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int sum = dp[c][d] - dp[a-1][d] - dp[c][b-1] + dp[a-1][b-1];
			sb.append(sum).append("\n");
		}
		System.out.print(sb.toString());
	}
}