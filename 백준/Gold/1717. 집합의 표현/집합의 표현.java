import java.util.*;
import java.io.*;

public class Main{
	static int N,M,w,a,b;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		init(N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(w==1) {
				// find 연산1
				System.out.println((find(a)==find(b))?"YES":"NO");
			}else {
				// union 연산
				union(a,b);
			}
		}
	}

	private static void init(int N) {
		parent = new int[N+1];
		for (int n = 0; n <= N; n++) {
			parent[n]=n;
		}
	}

	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		parent[rootA] = rootB;
		
	}

	private static int find(int a) {
		if(parent[a] == a) 
			return a;
		return parent[a] = find(parent[a]);
	}
}