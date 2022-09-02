import java.util.*;
import java.io.*;

public class Main{
    static int T,N,L,R,min;
    static List<Integer> arr;
    static int ans[];

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);
            ans = new int[N];

            L=0;
            R=N-1;

            for(int i=0; i<N; i++) {
                if(i%2!=0) {
                    ans[L] = arr.get(i);
                    L+=1;
                }
                else {
                    ans[R] = arr.get(i);
                    R-=1;
                }
            }
            min = Math.abs(ans[0]-ans[N-1]);
            for(int i=1; i<N; i++) {
                min = Math.max(min, Math.abs(ans[i]-ans[i-1]));
            }

            System.out.println(min);
        }
    }
}