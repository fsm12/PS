import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * O(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 f(n) ≤ c × g(n)인 양의 상수 c와 n0가 존재한다}
 * 즉, g(n)의 수행시간이 더 걸리는지 판단
 * 
 * f(n) = a1*n0 + a0
 * f(n) ≤ c × n0
 * 
 * a0가 음수인 경우..
 */

public class Main{
	static int a1, a0, c, n0;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a1 = Integer.parseInt(st.nextToken());
		a0 = Integer.parseInt(st.nextToken());
		
		c = Integer.parseInt(br.readLine());
		n0 = Integer.parseInt(br.readLine());
		
		System.out.println(((a1*n0+a0 <= c*n0)&&(c >= a1)) ? 1 : 0);
		
	}
}