import java.util.*;
import java.io.*;

/*
 * 12초 (추가 시간 없음)    1024 MB
 * n (1 ≤ n ≤ 4000)
 * A, B, C, D에 포함되는 정수 (2^28)
 * => A[a], B[b], C[c], D[d]의 합이 0인 (a, b, c, d) 쌍의 개수
 * 
 * sol 1) 완탐
 * N^4 = 4000^4 = 256조
 * java는 1초에 20,000,000 => 12초는 2억 4천까지 가능
 * N^2 * logN = 1600만 까지 가능할듯?
 * 
 * sol 2) 또 중간에서 만나기... 솔루션..너무 천잰데 
 * N^2은 가능하므로
 * A와 B, C와 D를 합쳐서 가능한 합을 모두 구하고 둘 중 하나만 정렬
 * 정렬한 아이들에 이분탐색을 써서 합이 0인 경우를 구하기
 * 놀랍게도 시간초과...!!
 * 
 * sol 3) 중간에서 만나서 뭘하지
 * 생각해보니 합이 0임을 만들어주는 경우가 여럿일 수 있음 (이게 시간초과의 원인이 아닐까 추측)
 * 중복값들을 어떻게 처리해야하나 구글링해보니 upper_bound, lower_bound를 써야한다고 함..!!
 * => 이것도 시간초과..? 
 * => 근데 나 왜 정렬 두번함? 한번만 해도 될텐데
 * 
 * 67% 틀렸습니다
 * => 정답의 범위가 int범위를 넘겠지
 */

public class Main{
	static int N,idx,pAB,pCD;
	static long ans;
	static int[] A,B,C,D,sumCD;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[n] = Integer.parseInt(st.nextToken());
			B[n] = Integer.parseInt(st.nextToken());
			C[n] = Integer.parseInt(st.nextToken());
			D[n] = Integer.parseInt(st.nextToken());
		}
		
		sumCD = new int[N*N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sumCD[idx++] = C[i]+D[j];
			}
		}
		Arrays.sort(sumCD);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp = A[i]+B[j];
				ans += upper_bound(0, N*N, -tmp) - lower_bound(0, N*N, -tmp);
			}
		}
		System.out.println(ans);
	}
	
	private static int upper_bound(int sp, int ep, long target) {
		while(sp < ep) {
			int mid = (sp+ep) / 2;
			if(sumCD[mid] <= target) {
				sp = mid + 1;
			} else {
				ep = mid;
			}
		}
		return ep;
	}
	
	private static int lower_bound(int sp, int ep, long target) {
		while(sp < ep) {
			int mid = (sp+ep) / 2;
			if(sumCD[mid] < target) {
				sp = mid + 1;
			} else {
				ep = mid;
			}
		}
		return ep;
	}
}