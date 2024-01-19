import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+5];
		dp[2]=1;
		dp[5]=1;
		for(int i=3; i<N+1; i++) {
			if(dp[i-2]!=0)
				dp[i] = dp[i-2]+1;
			if(5<=i && dp[i-5]!=0)
				dp[i] = Math.min(dp[i], dp[i-5]+1);
		}
		System.out.println(dp[N]==0?-1:dp[N]);
	}
}