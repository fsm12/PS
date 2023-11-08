import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] arr;
    static long ans=0;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());

        for (int i=0; i<N; i++) {
            if (arr[i] <= i) {
                break;
            }
            ans += arr[i] - i;
        }
        System.out.println(ans);
    }
}