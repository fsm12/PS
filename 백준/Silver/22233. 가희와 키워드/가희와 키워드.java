import java.util.*;
import java.io.*;

/*
 * 1.5 초	512 MB
 * 
 * [입력]
 * 1> 메모장에 적은 키워드 개수 N (1 ≤ N ≤ 2×10^5), 가희가 블로그에 쓴 글의 개수 M (1 ≤ M ≤ 2×10^5)
 * N> 메모장에 적은 키워드 N개
 * M> 가희가 쓴 글과 관련된 키워드가 , (쉼표)로 구분해서 주어ㅈㅁ
 * => x번째 줄에는 x번째 글을 쓰고 난 후에 메모장에 남아 있는 키워드의 개수
 * 
 * 메모장에 있었던 키워드는 가희가 글을 쓴 이후, 메모장에서 지워지게 됩니다.
 * 
 * sol) Set
 * 
 */

public class Main{
	static int N,M;
	static Set<String> set;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M; m++) {
			String[] inp = br.readLine().split(",");
			for(String tmp:inp) {
				if(set.contains(tmp))
					set.remove(tmp);
			}
			sb.append(set.size()).append("\n");
		}
		System.out.print(sb);
	}
}