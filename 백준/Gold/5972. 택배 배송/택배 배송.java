import java.util.*;
import java.io.*;


public class Main{
	static int N,M;
	static List<Node>[] adjList;
	static int[] dp;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N+1];
		for(int n=0; n<=N; n++) {
			adjList[n] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a].add(new Node(b,c));
			adjList[b].add(new Node(a,c));
		}
		
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		vis = new boolean[N+1];
		
		Queue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(1,0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(!vis[node.ab]) {
				vis[node.ab] = true;
				for(Node each : adjList[node.ab]) {
					if(dp[each.ab] > dp[node.ab] + each.c) {
						dp[each.ab] = dp[node.ab] + each.c;
	                    q.offer(new Node(each.ab, dp[each.ab]));
					}
				}
			}
			
		}
		bw.append(dp[N]+"");
		bw.flush();
	}
}

class Node implements Comparable<Node>{
	int ab,c;
	
	public Node(int ab, int c) {
		this.ab=ab;
		this.c=c;
	}
	
	public int compareTo(Node o) {
		return c-o.c;
	}
}