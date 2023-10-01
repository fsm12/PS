import java.io.*;
import java.util.*;

/* sol 1)
 * 만약 a가 음수이고, 잔액보다 큰 금액이라면
 * 	-(preB+curA-curB) 가 충전한 금액
 * 
 * 충전한 금액들의 최소공배수가 답임
 * 
 * ? 불가능한 경우
 * 전에 충전한 금액과 지금 충전해야할 금액이 서로소이고 1원으로 불가능할 때
 * -----
 * sol 2)
 * 출금의 경우, 충전 단위보다 현재 잔액이 크면 필요 이상으로 충전된 경우이므로 유효하지 않음
 * 충전해야 할 금액이 현재 잔액에 반영되지 않을 경우 또한 유효하지 않음
 * -----
 * sol 3)
 * 이전 케이스에서 충전단위보다 잔액이 큰 경우가 발생할 수 있으므로 minBalance변수를 가져와 이를 관리할 필요가 있음
 * -----
 * sol 4)
 * 유효한 충전단위는 1부터이므로, 입금만 들어왔을 땐 1로 설정해줘야함
 * sol 3의 경우가 가능할 때가 있는데 가장 처음 minBalance를 10e18로 초기화 했을 때 가능하므로 이를 예외처리 해줘야함
 * 
 */
public class Main {
	static int T;
	static long preB=0,curA,curB,minBalance=(long)10e18,ans=0;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		System.out.println(cal(T));
	}
	
	public static long cal(int N) throws IOException {
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			curA = Long.parseLong(st.nextToken());
			curB = Long.parseLong(st.nextToken());
			// 입금의 경우, 합한 값이 현재 잔액과 같은지 따져보기
			if(0<=curA && preB+curA!=curB)
				return -1;
			// 출금의 경우,
			if(curA<0) {
				// 충전하지 않아도 된다면
				if(-curA <= preB) {
					// 잔액이 일치하는지 확인하기
					if(preB+curA != curB)
						return -1;
				}
				// 충전해야한다면
				else {
					// 충전할 금액을 계산했을 때
					long curCharge = curB-curA-preB;
					
					// 충전 금액이 유효한지 검증
					if(curCharge <= 0)
						return -1;
					
					// minBalance 갱신
					minBalance = 0<curB ? Math.min(minBalance, curB): minBalance;
					
					// 최소공배수로 가능한 최솟값을 구함
					ans = gcb(ans, curCharge);
					
					// 충전 단위보다 현재 잔액이 같거나 크면 필요 이상으로 충전된 경우이므로 유효하지 않음(과거/현재 둘다 비교해야함)
					if(ans <= curB || (ans <= minBalance && minBalance != (long)10e18))
						return -1;
				}
			}
			preB=curB;
		}
		return ans==0?1:ans;
	}
	
	public static long gcb(long a, long b) {
		if(b==0)
			return a;
		return gcb(b, a%b);
	}
}