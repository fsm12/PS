import java.util.*;
import java.io.*;

public class Main{
    static int N,S;
    static long ans=0;
    static int[] v;
    static List<Integer> v1,v2;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        v = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        v1 = new ArrayList<>();
        v2 = new ArrayList<>();

        f(v, 0, N/2, 0, v1);
        f(v, N/2, N, 0, v2);

        Collections.sort(v1);
        Collections.sort(v2);

        int left = 0;
        int right = v2.size()-1;

        while(left<v1.size() && right>=0){
            int lv = v1.get(left);
            int rv = v2.get(right);
            if(lv+rv==S){

                long lc = 0;
                long rc = 0;

                while(left<v1.size() && v1.get(left)==lv){
                    lc++;
                    left++;
                }

                while(right>=0 && v2.get(right)==rv){
                    rc++;
                    right--;
                }

                ans += lc*rc;
            }

            if(lv+rv>S){
                right--;
            }

            if(lv+rv <S) {
                left++;
            }
        }
        if(S==0){
            System.out.println(ans-1);
        }else {
            System.out.println(ans);
        }
    }

    private static void f(int[] v, int i, int n, int sum, List<Integer> v2) {
        if(i==n){
            v2.add(sum);
            return;
        }

        f(v, i+1, n, sum + v[i], v2);
        f(v, i+1, n, sum, v2);
    }
}
