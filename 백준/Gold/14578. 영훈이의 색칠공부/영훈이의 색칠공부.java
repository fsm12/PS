import java.util.*;
import java.io.*;

/*
 * 1 초	128 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 10^5)
 * => 영훈이가 색칠 할 수 있는 모든 경우의 수 1,000,000,007 나눈 나머지
 * 
 * 각 행과 열에 빨간색 하나와 파란색 하나를 색칠
 * 
 * sol) dp
 * N*N 크기 2차원 배열로 연산? -> N^2 = 10^10 (불가능)
 * 어떻게든 줄여야함...
 * 
 * 각 칸은 빨, 파, 흰 중 하나임 
 * 빨,파는 각각 N개가 있어야함
 * 같은 색은 인접할 수 없음(상하좌우)
 * 
 * 각 행과 열에는 파란색 하나 빨간색 하나만 존재해야함
 * => 한 행이나 열에 빨간색,파란색이 정해지면 제외하고 생각해야함
 *    한 색을 미리 위치 지정해두고 생각?
 * 
 * [파란색 or 빨간색 위치 지정 경우의 수] = N!
 * 여기서는 파란색으로 위치 미리 잡아두었다고 가정
 * 빨간색은 모든 행과 열에 단 하나씩 있어야함 => 파란색을 칠한 칸이 포함된 행과 열은 삭제 가능!
 * 
 * ex) 
 * 파란색 위치 : B
 * <표 1>
 * 	B _ _ _
 * 	_ B _ _
 * 	_ _ B _
 * 	_ _ _ B
 * 처음 상태에서는 어느 _에 빨간색을 칠하더라도, 칠해진 칸이 가진 행과 열을 삭제했을 때 B는 2개만 남음 
 * bc) 모든 행과 열에 같은 수의 B가 있음
 * 
 * 오른쪽 상단 _를 R로 바꾸었다고 가정하면
 * 	B _ _ R
 * 	_ B _ _  => 1행과 4열은 조건을 만족함 
 * 	_ _ B _
 * 	_ _ _ B
 * 
 * 조건을 만족하는 행과 열을 제거 해보면
 * 	_ B _
 *  _ _ B
 *  _ _ _
 * 이 상태에서는 어느 _에 빨간색을 칠하는 지에 따라 B가 남는 개수가 다름 (1 또는 2)
 * bc) 모든 행과 열에 같은 수의 B가 있지 않음
 * 단, 3행 1열에 R을 두어야만 B가 2개남음
 * 
 * 점화식을 구하기위해 <표 1>을 나타내보면
 * SB = [1,2,3,4] (각 원소는 B가 위치한 열의 번호)
 * SR = [ , , , ] (단, SR[0]!=1 or SR[1]!=2 or SR[2]!=3 or SR[3]!=4)
 * SR[0~3] 각각에 넣는 경우의 수 : 3 (N-1) 본인제외라서
 * 
 * SR[0] = 3 넣었다고 가정
 * if SR[2] = 0 => 나머지 두 숫자만 넣으면 됨 : dp[N-2]
 * if SR[2] != 0 => 하나 넣었으니 나머지에서 넣으면 됨 : dp[N-1]
 * 
 * dp[N] = N! * (N-1) * (dp[N-2] + dp[N-1]);
 */

public class Main{
	static int N;
	static long nPac;
	static final int MOD = 1000000007;
	static long[] dp;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new long[N+2];
		dp[1] = 0;
		dp[2] = 1;
		nPac=2;
		for(int n=3; n<=N; n++) {
			dp[n] = ((n-1)*dp[n-2] % MOD + (n-1)*dp[n-1] % MOD) % MOD;
			nPac = nPac * n % MOD;
		}
		System.out.println(nPac*dp[N] % MOD);
	}
}