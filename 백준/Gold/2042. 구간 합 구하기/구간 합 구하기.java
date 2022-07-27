import java.util.*;
import java.io.*;

public class Main{
	static int N, M, K, n, s;
	static long a, b, c;
	static long[] numsN;
	static long[] list;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
		K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수
		
		numsN = new long[N];
		for (int n = 0; n < N; n++) {
			numsN[n] = Long.parseLong(br.readLine());
		}
		
		init(numsN);
		
		for (int i = 1; i <= M+K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(a==1) {
				update(1,s,1,b,c-list[(int) (s+b-1)]);
//				System.out.println("b를 c로 바꾼 후");
//				System.out.println(Arrays.toString(list));
			}else if(a==2) {
				System.out.println(calSum(1,s,1,b,c));
			}
		}		
	}
	
	private static void init(long[] numsN) {
		n = numsN.length;
		s = 1<<(int)Math.ceil(Math.log(n)/Math.log(2));
		
		list = new long[2*s];
		list[0] = 0; 	// 인덱스 1부터 시작하게 만듦
		
		//리프 채우기
		for (int i = 0; i < N; i++) {
			list[i+s] = numsN[i];
		}
		
		//내부노드
		for (int i = s-1; i >0; i--) {
			list[i] = list[i*2]+list[i*2+1];
		}
		
//		System.out.println("초기화 후");
//		System.out.println(Arrays.toString(list));
	}
	
	private static void update(int left, int right, int node, long target, long diff) {
		if(target<left || right<target) {
			return;
		}
		//연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
		list[node] +=diff;
		if(left != right) {
			int mid = (left + right)/2;
			update(left, mid, node*2, target, diff);
			update(mid+1, right, node*2+1, target, diff);
		}
	}

	private static long calSum(int left, int right, int node, long queryLeft, long queryRight) {
//		System.out.println(left+", "+right+", "+node+", "+queryLeft+", "+queryRight);
		// 전혀 속하지 않을때 -> return 0
		if(right < queryLeft || queryRight < left) {
			return 0;
		}// 완전히 속할 때 -> 갑 리턴
		else if(queryLeft<=left && right<=queryRight) {
			return list[node];
		}// 애매하게 속할때 -> 자식에게 토스
		else {
			int mid = (left + right)/2;
			long resultLeft = calSum(left, mid, node*2, queryLeft, queryRight);
			long resultRight = calSum(mid+1, right, node*2+1, queryLeft, queryRight);
			return resultLeft + resultRight;
		}
	}
}