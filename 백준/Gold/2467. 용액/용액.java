import java.util.*;
import java.io.*;

/*
 * 1 초	128 MB
 * 
 * [입력]
 * 1> 전체 용액의 수 N (2 이상 100,000 이하의 정수)
 * 1> 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 오름차순 (-1,000,000,000 이상 1,000,000,000 이하)
 * => 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력 (오름차순으로, 두 개 이상일 경우에는 그 중 아무것이나 하나)
 * 
 * 산성 용액(1부터 1,000,000,000), 알칼리성 용액(-1부터 -1,000,000,000)
 * 같은 양의 두 용액을 혼합한 용액의 특성값 = 각 용액의 특성값의 합
 * 
 * sol) 완탐
 * min(100,000C2) : 불가능
 * 
 * sol) 정렬 + 투포인터 
 * 이미 정렬은 되어있으므로 투포인터만
 * 
 * 틀렸습니다 
 * => 포인터 움직일 때 절댓값으로 넣어버림 ;; 
 */

public class Main{
	static int N, sp, ep;
	static long[] liquid, ans;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		liquid = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			liquid[n] = Long.parseLong(st.nextToken());
		}
		
		sp = 0;
		ep = N-1;
		ans = new long[] {liquid[sp], liquid[ep]};
		while(sp<ep) {
			if(Math.abs(liquid[sp]+liquid[ep]) < Math.abs(ans[0]+ans[1])) {
				ans[0] = liquid[sp];
				ans[1] = liquid[ep];
			}
			if(liquid[sp]+liquid[ep] < 0)
				sp+=1;
			else
				ep-=1;
		}
		System.out.println(ans[0]+" "+ans[1]);
	}
}