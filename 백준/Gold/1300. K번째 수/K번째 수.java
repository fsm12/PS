import java.util.*;
import java.io.*;

/* prob) 
 * N*N 배열의 모든 값들을 오름차순 정렬했을 때 K번쨰의 수를 찾아라
 * 
 * sol)
 * B[7] = 6
 * = N*N 배열을 오름차순 정렬했을 때, 7번째 수가 6이다
 * = N*N 배열을 오름차순 정렬했을 때, 6이하인 수가 7개는 무조건 존재한다.
 * => B[K] = ANS로 생각하면, [K == ANS이하인 수의 개수]를 만족하면 됨
 * 
 * ANS이하인 수의 개수?
 * => ANS를 1~N까지로 나누고 모두 합산 
 * 
 * ex) 3이하인 수의 개수 찾기
 * 1  2  3  4  => 3개(1,2,3) => 3/1 = 3
 * 2  4  6  8  => 1개(2)     => 3/2 = 1
 * 3  6  8  12 => 1개(3)     => 3/3 = 1
 * 4  8  12 16 => 0개        => 3/4 = 0
 * 
 */
public class Main{
	static int N,K,cnt;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		long left=1, right=K;
		while(left < right) {
			long mid = (left + right)/2;
			
			cnt = 0;
			for(int n=1; n<=N; n++) {
				cnt += Math.min(mid/n, N);
			}
			
			if(K <= cnt) 
				right = mid;
			else 
				left = mid + 1;
		}
		
		bw.append(String.valueOf(left));
		bw.flush();
	}
}