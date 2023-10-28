import java.util.*;
import java.io.*;

public class Main {
    static int M,N,ans=0;
    static int[][] map, dp;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int m=1; m<=M; m++) {
        	st = new StringTokenizer(br.readLine());
            for(int n=1; n<=N; n++) {
            	map[m][n] = Integer.parseInt(st.nextToken());
            	if(map[m][n]==0) {
            		dp[m][n] = Math.min(Math.min(dp[m-1][n], dp[m][n-1]), dp[m-1][n-1])+1;
            		ans = Math.max(ans, dp[m][n]);
            	}
            }
        }
        System.out.print(ans);
    }
}
