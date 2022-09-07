import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        arr[1] = 1;
        arr[2] = 2;

        for (int n = 3; n <= N; n++) {
            arr[n] = (arr[n-2]+arr[n-1])%10007;
        }
        System.out.println(arr[N]);
    }
}