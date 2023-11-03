import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
        // System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=1000000; i++)
        	dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb.toString());
    }
}