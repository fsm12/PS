import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> 우주신들의 개수(N<=1,000) 이미 연결된 신들과의 통로의 개수(M<=1,000)
 * N> 황선자를 포함하여 우주신들의 좌표가 (0<= X<=1,000,000), (0<=Y<=1,000,000)
 * M> 이미 연결된 통로가 주어진다. 번호는 위의 입력받은 좌표들의 순서라고 생각하면 된다. 좌표는 정수
 * => 만들어야 할 최소의 통로 길이 (출력은 소수점 둘째짜리까지)
 * 
 * 통로들의 길이는 2차원 좌표계상의 거리
 * 
 * sol) MST
 * 가능한 간선 정보를 담고 거리가 짧은 순으로 꺼내 크루스칼
 */

public class Main{
	static int N,M;
	static double ans;
	static Point[] points;
	static List<Node> nodes;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 부모 초기화
		parents = new int[N+1];
		for(int n=1; n<N+1; n++) {
			parents[n] = n;
		}
		
		// 입력
		points = new Point[N+1];
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			points[n] = new Point(a,b);
		}
		
		// 가능한 거리 구하기
		nodes = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				nodes.add(new Node(i, j, Math.sqrt(Math.pow(points[i].x-points[j].x, 2) + Math.pow(points[i].y-points[j].y, 2))));
			}
		}
		
		// 이미 이어진 통로 UF
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a) != find(b)) {
				union(a,b);
			}
		}
		
		// 짧은 거리부터 통로 UF
		Collections.sort(nodes);
		for(Node node : nodes) {
			if(find(node.x) != find(node.y)) {
				union(node.x, node.y);
				ans += node.dist;
			}
		}
		bw.append(String.format("%.2f", ans));
		bw.flush();
	}
	
	public static int find(int node) {
		if(parents[node] == node) {
			return node;
		}
		return parents[node] = find(parents[node]);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b)
			parents[b] = a;
		else
			parents[a] = b;
	}
}

class Point {
	int x,y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node>{
	int x, y;
	double dist;
	
	Node(int x, int y, double dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	
	public int compareTo(Node o) {
		return Double.compare(dist, o.dist);
	}
	
	public String toString() {
		return "("+x+", "+y+", "+dist+")";
	}
}