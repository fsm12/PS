import java.io.*;
import java.util.*;

/*
 * union-find
 */

public class Main {
	static int N,M,cnt;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		for(int n=1; n<=N; n++) {
			parent[n] = n;
		}
		
		for(int m=0; m<M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		for(int n=2; n<=N; n++) {
			if(find(parent[n])==1)
				cnt+=1;
		}
		System.out.println(cnt);
	}
	
	public static int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	
	public static void union(int a, int b) {
		int na = find(a);
		int nb = find(b);
		if(na<nb) {
			parent[nb] = na;
		}else {
			parent[na] = nb;
		}
	}
}
