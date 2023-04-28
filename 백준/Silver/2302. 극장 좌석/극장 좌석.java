import java.util.*;
import java.io.*;

/*
 * 
 * 1> 좌석의 개수 N (1 이상 40 이하)
 * N> 고정석의 개수 M 
 * => 주어진 조건을 만족하면서 사람들이 좌석에 앉을 수 있는 방법의 가짓수
 * 
 * 자기의 바로 왼쪽 좌석 또는 바로 오른쪽 좌석으로는 자리를 옮길 수 있다
 * vip는 반드시 자기 좌석에만 앉아야
 * 
 * sol) dp
 * dp[n] = dp[n - 1] + dp[n - 2], 고정석 기준 영역 나눠서 곱하기
 */

public class Main{
	static int N,M,VIP,ans=1;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		dp = new int[N+2];
		dp[0] = 1; // 모든 좌석이 VIP이면 경우의 수는 1임
		dp[1] = 1;
		dp[2] = 2;
		for (int n = 3; n <= N; n++) {
			dp[n] = dp[n - 1] + dp[n - 2];
		}

		int start = 0;
		while(M-->0) {
			int VIP = Integer.parseInt(br.readLine());
			ans *= dp[VIP-start-1];
			start = VIP;
		}
		ans *= dp[N-start];

		bw.write(ans+"\n");
		bw.flush();
	}
}