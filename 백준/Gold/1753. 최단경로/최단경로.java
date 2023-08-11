import java.util.*;
import java.io.*;

// 개선된 다익스트라 알고리즘은 PriorityQueue를 써야함!!

public class Main{
	static int V,E,start;
	static List<Node>[] adjList;
	static int[] dist;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		start = Integer.parseInt(br.readLine());
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList[a].add(new Node(b,c));
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		// 다익스트라
		PriorityQueue<Node> queue = new PriorityQueue<>();
		vis= new boolean[V + 1];
		queue.add(new Node(start, 0));
		dist[start] = 0;

		while(!queue.isEmpty()){
			Node curNode = queue.poll();
			int cur = curNode.eNode;
	
	       	if(vis[cur] == true)
	    	   continue;
	       	
	       	vis[cur] = true;
	       	for(Node node : adjList[cur]){
	           	if(dist[node.eNode] > dist[cur] + node.cost){
	               	dist[node.eNode] = dist[cur] + node.cost;
	               	queue.add(new Node(node.eNode, dist[node.eNode]));
	           	}
       		}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]).append("\n");
			}
		}
		System.out.print(sb.toString());
	}
}

class Node implements Comparable<Node>{
    int eNode, cost;

    public Node(int eNode, int cost){
        this.eNode = eNode;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}