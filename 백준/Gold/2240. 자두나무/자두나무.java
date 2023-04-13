import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> T, W
 * T> 자두가 떨어지는 나무의 번호가 1 또는 2
 * => 자두가 받을 수 있는 자두의 최대 개수를 출력
 * 
 * 자두는 T(1≤T≤1,000)초 동안 떨어지게 된다. 자두는 최대 W(1≤W≤30)번만 움직이고 싶어 한다.
 * 자두는 1번 자두나무 아래에 위치해 있다고 한다.
 * 
 * 2^30 => 불가
 * 
 * sol)
 * dp[T][W][k] = 자두가 i초까지 j번만의 이동으로 k나무에 있을 때 받을 수 있는 자두의 최대 개수
 * dp[T][W][1] = 1번 나무에서 그대로 있던 경우 + 2번 나무에서 온 경우
 * 				dp[T-1][W][1] + 1, dp[T-1][W-1][2]+1
 */


public class Main{
	static int T,W,ans;
	static int[][][] dp;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		dp = new int[T+1][W+2][2];
		for (int t = 1; t <= T; t++) {
			int tmp = Integer.parseInt(br.readLine());
            for (int w = 1; w <= W + 1; w++) {
                if (tmp == 1) {
                    dp[t][w][0] = Math.max(dp[t - 1][w][0], dp[t - 1][w - 1][1]) + 1;
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][0]);
                } else {
                    if (t == 1 && w == 1) continue;
                    dp[t][w][0] = Math.max(dp[t - 1][w][0], dp[t - 1][w - 1][1]);
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][0]) + 1;
                }
            }
        }
		
		for (int i = 1; i <= W + 1; i++) {
            ans = Math.max(ans, Math.max(dp[T][i][0], dp[T][i][1]));
        }
		System.out.println(ans);
	}
}