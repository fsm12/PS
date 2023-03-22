import java.util.*;
import java.io.*;

/*
2 초	128 MB

1> N(1 ≤ N ≤ 30)
=> 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수

sol) dp
dp[n] = 3×n 공간을 채우기 위한 경우의 수

< 규칙 찾기 >
N%2==1 : 불가능 (블록이 차지하는 칸수는 무조건 짝수)
N==2 => [1x2(3개)], [1x2, 2x1(2개)] : 3개
N==4 =>  (N=2, N=2) + 예외케이스(중간에 1x2가 2개 오는 경우) : 11개
 dp[4] =  dp[2]*2   +              2
N==6 =>  (N=4, N=2)  + (N=2, N=4예외) + 예외   : 41개
 dp[6] = dp[4]*dp[2] +   dp[2]*2     + 2
N==8 =>  (N=6, N=2) + (N=4, N=4예외) + (N=2, N=6예외) + 예외  : 153
 dp[8] = d[6]*dp[2] +    dp[4]*2    +    dp[2]*2   + 2
 
=> dp[N] = (dp[N-2]*dp[2]) + (dp[N-4]*2) + (dp[N-6]*2) + (dp[N-8]*2) + ... + (dp[0]*2) (단, dp[0]=1)
*/

public class Main{
	static int N,ans;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		if(N%2==1) {
			ans = 0;
		}else {
			dp = new int[N+1];
			dp[0] = 1;
			dp[2] = 3;
			for (int i = 4; i <= N; i += 2) {
                dp[i] = dp[i-2] * dp[2];
                for (int j = i - 4; j >= 0; j -= 2) {
                    dp[i] += 2*dp[j];
                }
            }
			ans = dp[N];
		}
		System.out.println(ans);
	}
}