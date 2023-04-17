import java.util.*;
import java.io.*;

/*
 * 2 초	512 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 1,000,000)
 * 1> X1, X2, ..., XN (-10^9 ≤ Xi ≤ 10^9)
 * => X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력
 * 
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수
 * => i번쨰 위치 값은 몇번째로 큰 값인가
 */

public class Main{
	static int N, rank;
	static int[] arr, sort_arr;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sort_arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			int v = Integer.parseInt(st.nextToken());
			arr[n] = v;
			sort_arr[n] = v; 
		}
		
		Arrays.sort(sort_arr);
		
		map = new HashMap<>();
		for(int e : sort_arr) {
			if(!map.containsKey(e)) {
				map.put(e, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int e : arr) {
			sb.append(map.get(e)).append(" ");
		}
		
		System.out.println(sb);
	}
}
