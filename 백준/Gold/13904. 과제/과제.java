import java.util.*;
import java.io.*;

/*
 * 1 초	256 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 1,000)
 * N> d : 과제 마감일까지 남은 일수(1 ≤ d ≤ 1,000) w : 과제의 점수 (1 ≤ w ≤ 100)
 * => 얻을 수 있는 점수의 최댓값
 * 
 * sol) 우선순위 큐
 * 1st 점수가 높은 아이부터, 2nd 마감일이 안타까운 아이부터 
 */

public class Main{
	static int N, maxDay, ans;
	static boolean[] days;
	static PriorityQueue<DW> pq;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pq = new PriorityQueue<DW>();
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.add(new DW(d,w));
			maxDay = Math.max(maxDay, d);
		}
		
		days = new boolean[maxDay+1];
		while(!pq.isEmpty()) {
			DW dw = pq.poll();
			for(int curDay = dw.d; curDay >= 1; curDay--) {
				if(!days[curDay]) {
					days[curDay] = true;
					ans += dw.w;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}

class DW implements Comparable<DW>{
	int d,w;
	
	public DW(int d, int w) {
		this.d = d;
		this.w = w;
	}

	@Override
	public int compareTo(DW o) {
		if(o.w == w)
			return d - o.d;
		return o.w - w;
	}
}