import java.io.*;
import java.util.*;

public class Main{
	static int N,K;
	static int[] chicken;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		chicken = new int[N];
		for(int i=0; i<N; i++) {
			chicken[i] = Integer.parseInt(st.nextToken());
        }
        
		K = Integer.parseInt(br.readLine());
		
		int part = N/K;
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[part];
		for(int i=0; i<K; i++) {
			for(int j=0; j<part; j++) {
				arr[j] = chicken[j+part*i];
			}
			Arrays.sort(arr);
			for(int j=0; j<part; j++) {
				sb.append(arr[j]).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}