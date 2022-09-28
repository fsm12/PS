import java.util.*;
import java.io.*;

public class Main{
    static int T,N;
    static double ans;
    static boolean[] isC;
    static int[][] point;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = pint(br.readLine());
        while (T-->0) {
            N = pint(br.readLine());
            isC=new boolean[N];
            point= new int[N][2];
            int sumx=0,sumy=0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                point[i][0]=pint(st.nextToken());
                point[i][1]= pint(st.nextToken());
                sumx+=point[i][0];
                sumy+=point[i][1];
            }

            ans=Double.MAX_VALUE;
            rec(0,0, sumx, sumy);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }

    static void rec(int cnt, int prev, int x, int y) {
        if(cnt==N/2) {
            ans = Math.min(ans, Math.sqrt((double)x*x + (double)y*y) );
            return;
        }
        for (int i = prev; i < N; i++)
            rec(cnt+1, i+1, x-2*point[i][0], y-2*point[i][1]);
    }

    static int pint(String s) {
        return Integer.parseInt(s);
    }
}