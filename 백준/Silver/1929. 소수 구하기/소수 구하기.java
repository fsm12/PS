import java.util.*;
import java.io.*;

public class Main{
	static int M,N;
	static boolean[] isPrime;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		isPrime = new boolean[N+1];
		isPrime[1] = true;
		for(int i=2; i<N+1; i++) {
			if(!isPrime[i]) {
				for(int j=2; i*j<=N; j++) {
					isPrime[i*j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=M; i<=N; i++) {
			if(!isPrime[i])
				sb.append(i).append("\n");
		}
		
		System.out.print(sb);
	}
}