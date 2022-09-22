import java.util.*;
import java.io.*;

public class Main{
    static int L, P;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int N = Integer.parseInt(st.nextToken());
            System.out.print((N - L*P)+" ");
        }
    }
}