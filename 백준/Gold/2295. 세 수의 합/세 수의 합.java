import java.io.*;
import java.util.*;

/*
 * 두 수를 고름 => N^2 = 1,000,000
 * 
 * 두 수를 더한 배열, 나머지 수 배열 => 합했을 때 수를 찾을 수 있는가
 * A+B+C = want
 * A+B = want-C ==> want-C가 A+B 집합에 있는가?
 */


public class Main {
	static int N;
	static int[] origin, twoSum;
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/origin.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new int[N];
        twoSum = new int[N*N];

        for(int i=0; i<N; i++) {
            origin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(origin);
        
        int idx = 0;
        for (int i=0; i<N; i++) {
            for (int j=i; j<N; j++) {
                twoSum[idx++] = origin[i] + origin[j];
            }
        }
        Arrays.sort(twoSum, 0, idx - 1);

        for(int i=N-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                if(Arrays.binarySearch(twoSum, 0, idx -1, origin[i]-origin[j]) < 0) 
                	continue;
                System.out.println(origin[i]);
                return;
            }
        }
    }
}