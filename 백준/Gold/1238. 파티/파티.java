import java.util.*;
import java.io.*;

public class Main{
	static int N,M,X,ans;
	static List<Node>[] AToXadjList, XToAadjList;
	static int[] AToXdist, XToAdist;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		
		AToXadjList = new ArrayList[N];
		XToAadjList = new ArrayList[N];
		for(int i=0; i<N; i++) {
			AToXadjList[i] = new ArrayList<>();
			XToAadjList[i] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			AToXadjList[s-1].add(new Node(e-1,t));
			XToAadjList[e-1].add(new Node(s-1,t));
		}
		
		AToXdist = dijkstra(AToXadjList);
		XToAdist = dijkstra(XToAadjList);
		
		for(int n=0; n<N; n++) {
			ans = Math.max(ans, AToXdist[n]+XToAdist[n]);
		}
		
		bw.append(String.valueOf(ans));
		bw.flush();
	}
	
	public static int[] dijkstra(List<Node>[] adjList) {		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		boolean[] vis = new boolean[N + 1];

		while(!pq.isEmpty()){
			int prevEnd = pq.poll().end;
	
	       	if(vis[prevEnd])
	    	   continue;
	       	
	       	vis[prevEnd] = true;
	       	for(Node node : adjList[prevEnd]){
	       		int end = node.end;
	       		int cost = node.cost;
	           	if(!vis[end] && dist[prevEnd] + cost < dist[end]){
	               	dist[end] = dist[prevEnd] + cost;
	               	pq.add(new Node(end, dist[end]));
	           	}
       		}
		}
		return dist;
	}
}

class Node implements Comparable<Node>{
    int end, cost;

    public Node(int end, int cost){
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}