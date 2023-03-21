import java.util.*;
import java.io.*;

/* 0.5 초(Java 1초)	128 MB
 * 
 * [입력]
 * 1> N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)
 * 1> N개로 구성된 수열
 * => 구하고자 하는 최소의 길이(불가능 0)
 * 
 * sol) 투포인터
 * 
 */

public class Main{
	static int N,S,ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		ans = N+1;
		int sp=0, ep=0, cur=arr[sp];
		while(sp<=ep) {
			if(cur>=S) {
				ans = Math.min(ans, ep-sp+1);
				if(ans==1)
					break;
				cur -= arr[sp];
				sp+=1;
			}else {
				ep+=1;
				if(ep>=N) {
					if(ans == N+1) {
						ans = 0;
					}
					break;
				}
				cur += arr[ep];
			}
		}
		System.out.println(ans);
	}
}