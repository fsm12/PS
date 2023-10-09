import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1] = 1;
 
        int min = 0;
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;
            for (int j=1; j*j<=i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[N]);
    }
}