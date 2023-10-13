import java.io.*;
import java.util.*;

/*
 * 레벨 K에는 딱 K개의 장난감이 있어야 함
 * 각 레벨에 다른 색은 같게 되어야 한다.
 */
public class Main {
	static int N,R,G,B;
    static long[][][][] dp;
    static long[][] dp_comb;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        dp = new long[N+1][R+1][G+1][B+1];
        dp_comb = new long[N+1][N+1];
        
        System.out.println(solve(N, R, G, B));
    }

	public static long solve(int n, int r, int g, int b) {
        if (r<0 || g<0 || b<0) 
        	return 0;
        if (n<=0) 
        	return 1;

        if (dp[n][r][g][b] != 0) 
        	return dp[n][r][g][b];

        // 1개의 색으로 다 칠하는 경우
        dp[n][r][g][b] += solve(n-1, r-n, g, b);
        dp[n][r][g][b] += solve(n-1, r, g-n, b);
        dp[n][r][g][b] += solve(n-1, r, g, b-n);

        // 2개의 색으로 다 칠하는 경우
        if (n % 2 == 0) {
            long combination = getCombination(n, n/2, 2);
            dp[n][r][g][b] += combination * solve(n-1, r-n/2, g-n/2, b);
            dp[n][r][g][b] += combination * solve(n-1, r, g-n/2, b-n/2);
            dp[n][r][g][b] += combination * solve(n-1, r-n/2, g, b-n/2);
        }

        // 3개의 색으로 다 칠하는 경우
        if (n % 3 == 0) {
            long combination = getCombination(n, n/3, 3);
            dp[n][r][g][b] += combination * solve(n-1, r-n/3, g-n/3, b-n/3);
        }
        return dp[n][r][g][b];
    }

    static long getCombination(int n, int num, int k) {
        if (dp_comb[n][num] != 0) 
        	return dp_comb[n][num];

        long ret = 1L;
        for (int i=1; i<=n; i++) {
            ret *= i;
        }

        for (int i=0; i<k; i++) {
            for (int j=1; j<=num; j++) {
                ret /= j;
            }
        }
        return dp_comb[n][num] = ret;
    }
}