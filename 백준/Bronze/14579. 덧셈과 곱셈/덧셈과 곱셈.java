import java.util.*;
import java.io.*;

public class Main {
    static int a,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        long firstSum = 0;
        for (int i = 1; i < a+1; i++) {
            firstSum+=i;
        }

        long sum=1;
        long dp[] = new long[b-a+2];
        dp[0] = firstSum;
        for (int i = 0; i < b-a+1; i++) {
            sum *= dp[i];
            sum %= 14579;
            dp[i+1] = (dp[i]+(a+i+1));
        }
        System.out.println(sum);
    }
}