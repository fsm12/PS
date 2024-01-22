import java.io.*;
import java.util.*;

public class Main{
	static int N,M,num;
    
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append("0 1").append("\n");
		for(int i=0; i<M-1; i++) {
			sb.append("1 ").append(i+2).append("\n");
		}
		num=M;
		for(int i=num; i<N-1; i++) {
			sb.append(i).append(" ").append(i+1).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}