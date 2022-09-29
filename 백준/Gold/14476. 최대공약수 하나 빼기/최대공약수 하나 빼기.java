import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int[] gcdLtoR;
    static int[] gcdRtoL;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //LtoR 만들기
        gcdLtoR[0] = nums[0];
        for(int i=1; i<N; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i-1], nums[i]);
        }

        //RtoL 만들기
        gcdRtoL[N-1] = nums[N-1];
        for(int i=N-2; i>=0; i--) {
            gcdRtoL[i] = gcd(gcdRtoL[i+1], nums[i]);
        }

        //k 선정하기
        int max = -1;
        int maxIndex = 0;
        for(int i=0; i<N; i++) {
            int gcd = 0;
            // 0
            if(i == 0)
                gcd = gcdRtoL[1];
                // N - 1
            else if(i == N-1)
                gcd = gcdLtoR[N-2];
                // 중간 (1 ~ N - 2)
            else
                gcd = gcd(gcdLtoR[i-1], gcdRtoL[i+1]);

            if(nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }
        if(max == -1) {
            bw.write("-1");
        } else
            bw.write(String.valueOf(max) + " " +String.valueOf(nums[maxIndex]));

        bw.flush();
        br.close();
        bw.close();
    }

    //gcd(a, b) == gcd(b, r) == gcd(b, a%b), stop when a % b == 0
    static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}