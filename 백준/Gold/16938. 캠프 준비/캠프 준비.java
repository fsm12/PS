import java.io.*;
import java.util.*;

public class Main {
    static int N,X,L,R,ans=0;
    static int[] A;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        dfs(Integer.MAX_VALUE, 0, 0, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int Amin, int Amax, int cnt, int idx, int Asum) {
        if(cnt >= 2){
            if(Asum >= L && Asum <= R && Amax - Amin >= X){
                ans++;
            }
        }
        for(int i = idx; i < N; i++){
            dfs(Math.min(Amin, A[i]), Math.max(Amax, A[i]), cnt+1, i+1, Asum + A[i]);
        }
    }
}