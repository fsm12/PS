import java.util.*;
import java.io.*;

/*
 * 2 초	192 MB
 * N(1 ≤ N ≤ 1,000,000)
 * => 생성자가 없는 경우에는 0을 출력
 */

public class Main{
	static int N, ans;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			int num = n;
			int sum = 0;
			
			while(num!=0) {
				sum += num%10;
				num /= 10;
			}
			
			if(sum+n == N) {
				ans = n;
				break;
			}
		}
		System.out.println(ans);
	}
}