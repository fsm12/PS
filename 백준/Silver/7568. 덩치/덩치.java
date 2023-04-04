import java.util.*;
import java.io.*;

/*
 * 1 초	128 MB
 * 
 * [입력]
 * 1> 전체 사람의 수 N (2 ≤ N ≤ 50)
 * N> 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고
 * => 덩치 등수를 구해서 그 순서대로 첫 줄에 출력
 * 
 * A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다
 * N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
 * 
 */

public class Main{
	static int N, rank;
	static List<Integer[]> arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<>();
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Integer[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		for(int n=0; n<N; n++) {
			rank = 1;
			for(int i=0; i<N; i++) {
				if(n==i)
					continue;
				if(arr.get(n)[0] < arr.get(i)[0] && arr.get(n)[1] < arr.get(i)[1]) {
					rank+=1;
				}
			}
			System.out.print(rank+" ");
		}
	}
}