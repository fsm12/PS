import java.util.*;
import java.io.*;

/*
 * 2 초	256 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 1,000,000)
 * N > 1,000,000보다 작거나 같은 정수
 * => 정렬
 * 
 */

public class Main{
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int n=0; n<N; n++) {
			sb.append(arr[n]).append("\n");
		}
        
		System.out.print(sb);
	}
}