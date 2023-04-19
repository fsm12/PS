import java.util.*;
import java.io.*;

public class Main{
	static int N,M;
	static Map<Integer, Integer> map;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new HashMap<>();
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) {
				map.replace(tmp, map.get(tmp)+1);
				continue;
			}
			map.put(tmp, 1);
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M; m++) {
			int val = Integer.parseInt(st.nextToken());
			if(map.containsKey(val)) {
				sb.append(map.get(val)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}