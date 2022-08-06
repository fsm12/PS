import java.io.*;

public class Main{
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+4];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(Math.min(dp[i-1]+1, dp[i%2==0?i/2:i-1]+1), dp[i%3==0?i/3:i-1]+1);
        }
        System.out.println(dp[N]);
    }
}