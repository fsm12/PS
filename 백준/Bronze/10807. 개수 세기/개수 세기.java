import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    static int total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if(nums[i]==K){
                total+=1;
            }
        }
        System.out.println(total);
    }
}