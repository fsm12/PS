import java.util.*;
import java.io.*;

public class Main{
	static int N,a,b;
	static int[] ans;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N];
		for(int n=0; n<N; n++) {
			adjList[n] = new ArrayList<>();
		}
		
		for(int n=0; n<N-1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			adjList[a].add(b);
			adjList[b].add(a);
		}

		ans = new int[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		Arrays.fill(ans, -1);
		ans[0] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<adjList[cur].size(); i++) {
				int idx = adjList[cur].get(i);
				if(ans[idx]==-1) {
					ans[idx] = cur;
					q.add(idx);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N; i++) {
			sb.append(ans[i]+1).append("\n");
		}
		System.out.print(sb.toString());
	}
}