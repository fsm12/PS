import java.util.*;
import java.io.*;

public class Main{
    static int N, max=-1;
    static int[] port, lis;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        port = new int[N];
        for (int n = 0; n < N; n++) {
            port[n] = Integer.parseInt(st.nextToken());
        }

        lis = new int[N];
        lis[0] = 1;
        for (int ni = 1; ni < N; ni++) {
            lis[ni] = 1;
            for(int nj=0; nj<ni; nj++) {
                if(port[ni]>port[nj]) {
                    lis[ni] = Math.max(lis[nj]+1, lis[ni]);
                }
            }
        }

        for(int num : lis) {
            max = Math.max(num, max);
        }
        System.out.println(max);
    }
}