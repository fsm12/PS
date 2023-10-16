import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] pointer, dp;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pointer = new int[101];
		for (int i=1; i<pointer.length; i++) {
			pointer[i] = i;
		}

		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pointer[x] = y;
		}
		
		dp = new int[101];
		System.out.println(bfs(1));
	}

	private static int bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		dp[node] = 0; 

		while (true) {
			int cur = q.poll();
			for (int i=1; i<7; i++) {				
				if (100 < cur+i) { 
					continue;
				}
				
				if (dp[pointer[cur+i]] == 0) { 
					q.offer(pointer[cur+i]);
					dp[pointer[cur+i]] = dp[cur] + 1;
				}
				if (pointer[cur+i] == 100) {
					return dp[100];
				}
			}
		}
	}
}