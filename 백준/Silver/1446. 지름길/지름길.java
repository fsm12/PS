import java.util.*;
import java.io.*;

public class Main{
	static int N,D;
	static List<Road> roads;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		roads = new ArrayList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			// 고속도로 영역에 속하고, 지름길이 맞으면 추가 
			if(e <= D && e-s > len) {
				roads.add(new Road(s,e,len));
			}
		}
		
		dist = new int[D+1];
		for(int i=0; i<D+1; i++) {
			dist[i] = i;
		}
		
        // 다익스트라
		PriorityQueue<Road> q = new PriorityQueue<>();
		q.add(new Road(0,0,0));
		
		while(!q.isEmpty()) {
			Road cur_road = q.poll();
			for(Road road : roads) {
				if(road.s >= cur_road.e) {
					if(road.e > D)
						continue;
					int walk = road.s - cur_road.e;
					if(dist[road.e] > dist[cur_road.e] + road.len + walk) {
						dist[road.e] = dist[cur_road.e] + road.len + walk;
						q.add(new Road(cur_road.e, road.e, dist[road.e]));
					}
				}
			}
			dist[D] = Math.min(dist[D], dist[cur_road.e] + D - cur_road.e);
		}
		System.out.println(dist[D]);
	}
}

class Road implements Comparable<Road>{
	int s,e,len;
	
	public Road(int s, int e, int len) {
		this.s = s;
		this.e = e;
		this.len = len;
	}
	
	public int compareTo(Road o) {
		return e-o.e;
	}

	@Override
	public String toString() {
		return "Road [s=" + s + ", e=" + e + ", len=" + len + "]";
	}
}