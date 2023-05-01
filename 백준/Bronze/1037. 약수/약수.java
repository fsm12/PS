import java.util.*;
import java.io.*;

public class Main{
	static int N, maxV=Integer.MIN_VALUE, minV=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n=0; n<N; n++) {
			int num = Integer.parseInt(st.nextToken());
			minV = Math.min(minV, num);
			maxV = Math.max(maxV, num);
		}
		
		bw.write(minV * maxV+"");
		bw.flush();
	}
}