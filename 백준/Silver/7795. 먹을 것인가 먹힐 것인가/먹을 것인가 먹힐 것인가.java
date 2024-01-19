import java.io.*;
import java.util.*;

public class Main{
	static int T,N,M,ans;
	static int[] a,b;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			a = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			a[N] = Integer.MAX_VALUE;

			b = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			b[M] = Integer.MAX_VALUE;
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			// b보다 큰 a를 찾기 (이분탐색으로)
			ans=0;
			for(int i=0; i<b.length-1; i++) {
				int num = upperBound(0, a.length-1, b[i]);
				ans += N - num;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	// 특정 target(b)보다 큰 (a의)첫번째 원소의 인덱스
	private static int upperBound(int l, int h, int target) {
	    while(l < h) {
	    	int mid = (l+h) / 2;
	        if(a[mid] <= target) {
	        	l = mid+1;
	        }else {
	        	h = mid;
	        }
	    }
	    return h;
	}
}