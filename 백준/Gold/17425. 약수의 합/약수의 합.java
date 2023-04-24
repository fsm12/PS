import java.util.*;
import java.io.*;

/*
 * 1 초 (추가 시간 없음)	512 MB
 * 
 * [입력]
 * 1> T(1 ≤ T ≤ 100,000)
 * T> 자연수 i(1 ≤ i ≤ 1,000,000)
 * => g(i)
 * 
 * f(A) : 자연수 A의 약수의 합은 A의 모든 약수를 더한 값
 * g(x) : x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값
 * 
 * g(i) = f(i) + f(i-1) + ... + f(1)
 * 
 * sol) 누적합
 * 1~최댓값까지 가능 수를 더하기
 * 
 */

public class Main {
	static int T,i;
    static final int SIZE = 1000001;
    static long[] cnt;
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        cnt = new long[SIZE];
        for (int s=1; s<SIZE; s++) {
        	cnt[s] += cnt[s-1];
            int i = 1;
            while (s*i < SIZE) {
            	cnt[s*i] += s;
                i+=1;
            }
        }

        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            sb.append(cnt[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }
}