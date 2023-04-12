import java.util.*;
import java.io.*;

/*
 * 1 초	256 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 100,000)
 * N> i번점의 위치 xi와 yi (-100,000 ≤ xi, yi ≤ 100,000)
 * => N개의 줄에 점을 정렬한 결과를 출력
 */

public class Main{
	static int N;
	static List<int[]> points;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		points = new ArrayList<>();
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new int[] {x,y});
		}
		
		Collections.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0])
					return o1[1] - o2[1]; 
				return o1[0] - o2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int n=0; n<N; n++) {
			sb.append(points.get(n)[0]).append(" ").append(points.get(n)[1]).append("\n");
		}
		System.out.println(sb);
	}
}