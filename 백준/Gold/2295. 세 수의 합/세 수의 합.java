import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        int[] sumArr = new int[N*N];

        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sumArr[idx++] = input[i] + input[j];
            }
        }
        Arrays.sort(sumArr, 0, idx - 1);

        for(int i = N -1; 0 <= i; i--){
            for(int j = i; 0 <= j; j--){
                if(Arrays.binarySearch(sumArr, 0, idx -1, input[i]-input[j]) < 0) 
                	continue;
                System.out.println(input[i]);
                return;
            }
        }
    }
}