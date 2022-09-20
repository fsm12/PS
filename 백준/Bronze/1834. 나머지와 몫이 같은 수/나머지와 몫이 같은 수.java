import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static long sum=0;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i<N; i++) {
            sum += (long)N*i+i;
        }
        System.out.println(sum);
    }
}