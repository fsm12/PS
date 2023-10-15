import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		nCr(0,0,new ArrayList<>());
		
		System.out.print(sb.toString());
	}
	
	public static void nCr(int depth, int start, List<Integer> ans) {
		if(depth == M) {
			for(int m=0; m<M; m++) {
				sb.append(ans.get(m)).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i=start; i<N; i++) {
			List<Integer> cur = new ArrayList<>(ans);
			cur.add(num[i]);
			nCr(depth+1, i+1, cur);
		}
	}
}