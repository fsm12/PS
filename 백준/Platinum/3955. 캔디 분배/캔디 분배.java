import java.util.*;
import java.io.*;

public class Main{
	static int t,K,C;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		t=Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken()); // 파티 참가인원
			C = Integer.parseInt(st.nextToken()); // 한봉지에 있는 사탕개수
			//-Kx + Cy = 1 -> K*(-x) + Cy = 1 ( a : K, b : C ) [x: 나누어줄 사탕개수, y: 사탕봉지수]
			// x = x0 + b/gcd(a,b) * k, y = y0 - a/gcd(a,b) * k 
			// gcd(a,b) => 확장유클리드호제법을 이용해 구할 수 있음 (리턴받은 r)
			EGResult result = extendedGcd(K, C);
			if(result.r != 1) {
				System.out.println("IMPOSSIBLE");
			}else {
				// x0 = s, y0 = t 이지만, 만약 Ax+By=C에서 C가 1이 아니라면 초기해에 C를 곱해주어야한다.
				long x0 = result.s;
				long y0 = result.t;
				
				// 일반해 구하기
				long x = x0 + C/result.r; // x = x0 + C/gcd(K,C) + 상수k
				long y = y0 - K/result.r;
				
				/*
				 * 상수 k 범위 유추하기
				 * 문제 조건 : Ax+By=C일때, 
				 * x는 나누어줄 사탕 개수이므로 x>0인 자연수
				 * y는 사탕봉지수이고, 1<y<10^9
				 * 
				 * 내가 설정한 식에서의 조건
				 * => -x로 두었으므로 x<0
				 * 
				 * 대입해보기
				 * 1. x<0 
				 * (x = x0 + C/gcd(K,C) * k)
				 * => x0 + C/gcd(K,C) * k < 0
				 * => k < -x0 * (gcd(K,C) / C)
				 * 
				 * 2. 0<y<10^9 
				 * (y = y0 - K/gcd(K,C) * k) 
				 * => 0 < y0 - K/gcd(K,C) * k <= 1e9
				 * => - y0 < - K/gcd(K,C) * k <= 1e9 - y0
				 * => y0 > K/gcd(K,C) * k >= y0 - 1e9
				 * => y0 * gcd(K,C)/K > k >= (y0 - 1e9) * gcd(K,C)/K
				 * 
				 * (y0 - 1e9) * gcd(K,C)/K <= k < y0 * gcd(K,C)/K
				 *                             k < -x0 * (gcd(K,C) / C)
				 * 이 영역이면 gcd(K,C) = 1이다                            
				 * 즉,
				 * (y0 - 1e9) / K <= k < y0 / K
				 *                   k < -x0 / C
				 *                   
				 * kLimitFromY <= k < kFromY  
				 *                k < kFromX             
				 * 
				 */
				
				// 만족하는 k가 있는지 찾고 k를 통해 y를 구한다.
				long kFromY = (long)Math.ceil((double) y0 / (double) K)-1;
				// ㄴ 3은 2로 3.5도 2로 만들어주려면 올림후 -1해야한다 (부등호에 = 없다는 전제 - 있다면 바로 내림 가능)
				long kFromX = (long)Math.ceil((double) -x0 / (double) C)-1;
				long k = Math.min(kFromX, kFromY);
				long kLimitFromY = (long)Math.ceil((y0-1e9)/(double)K);
				if(kLimitFromY <= k) {
					System.out.println(y0 - K * k);	
				}else {
					System.out.println("IMPOSSIBLE");
				}
			}
		}
	}
	
	static EGResult extendedGcd(long a, long b) {
		long s0=1, t0=0, r0=a;
		long s1=0, t1=1, r1=b;
		
		long temp;
		while(r1!=0) {
			long q = r0/r1;
			
			temp = r0 - q*r1;
			r0 = r1;
			r1 = temp;
			
			temp = s0 - q*s1;
			s0 = s1;
			s1 = temp;
			
			temp = t0 - q*t1;
			t0 = t1;
			t1 = temp;
		}
		return new EGResult(s0, t0, r0);
	}
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }

    @Override
    public String toString() {
        return "ExtendedGcdResult [s=" + s + ", t=" + t + ", gcd=" + r + "]";
    }
}