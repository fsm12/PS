import java.util.*;
import java.io.*;

public class Main{
	static int N,MAX;
	static boolean[] isPrime;
	static List<Integer> inp;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inp = new ArrayList<>();
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			inp.add(N);
			MAX = Math.max(MAX, N);
		}
		
		isPrime = new boolean[2*MAX+1];
		isPrime[1] = true;
		for(int i=2; i<=2*MAX; i++) {
			if(!isPrime[i]) {
				for(int j=2; i*j<=2*MAX; j++) {
					isPrime[i*j] = true;
				}
			}
		}
		for(int inp_val : inp) {
			int cnt = 0;
			for(int i=inp_val+1; i<=2*inp_val; i++) {
				if(!isPrime[i])
					cnt+=1;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	}
}