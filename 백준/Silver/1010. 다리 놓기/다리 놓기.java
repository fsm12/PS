import java.util.*;
import java.io.*;

public class Main{
	static int T,N,R;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			double n=1, r=1;
			for(int i=N; i>N-R; i--) {
				n*=i;
				r*=(R-N+i);
			}
			sb.append(String.format("%.0f\n", n/r));	
		}
		bw.write(sb+"");
		bw.flush();
	}
}