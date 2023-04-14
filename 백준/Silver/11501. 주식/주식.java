import java.util.*;
import java.io.*;

/*
 * 5 초	256 MB
 * 
 * [입력]
 * 1> 테스트케이스 수
 * 1> 날의 수를 나타내는 자연수 t(2 ≤ t ≤ 1,000,000)
 * 1> 날 별 주가를 나타내는 N개의 자연수 (10,000이하)
 * => 테스트케이스 별로 최대 이익을 나타내는 정수 하나
 * 
 * 주식 하나를 산다.
 * 원하는 만큼 가지고 있는 주식을 판다.
 * 아무것도 안한다.
 * =>  날 별로 주식의 가격을 알려주었을 때, 최대 이익이 얼마나 되는지 계산
 */

public class Main{
	static int T, D;
	static long ans, max;
	static long[] money;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			D = Integer.parseInt(br.readLine());
			money = new long[D];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int d = 0; d < D; d++) {
				money[d] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			max = 0;
			for(int d = D-1; d >= 0; d--) {
				if(money[d] > max) {
					max = money[d];
				}else {
					ans += (max - money[d]);
				}
			}	
			sb.append(ans).append("\n");
		}
		
		System.out.print(sb);
	}
}