import java.util.*;
import java.io.*;

public class Main{
    static int T,N;
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        dp = new int[10001][4];
        //1.dp배열 생성후 초기값 (1,2,3)은 값을 미리 넣어두기
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        //2.테케 반복문을 열고
        while(T-->0) {
            //3.N을 입력받는다
            N = Integer.parseInt(br.readLine());

            sb.append(Sum(N)+"\n");
        }
        System.out.print(sb.toString());
    }

    //dp배열에 N까지 값을 구하는 함수를 생성한다
    private static int Sum(int N) {
        for (int n = 4; n < N+1; n++) {
            //전 테케에서 이미 진행했을수 있으므로 값이 0이 아니라면 continue
            if(dp[n][1]!=0)
                continue;
            dp[n][1]=dp[n-1][1];
            dp[n][2]=dp[n-2][1]+dp[n-2][2];
            dp[n][3]=dp[n-3][1]+dp[n-3][2]+dp[n-3][3];
        }
        return dp[N][1]+dp[N][2]+dp[N][3];
    }
}