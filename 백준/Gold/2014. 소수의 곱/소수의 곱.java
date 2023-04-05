import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> K(1 ≤ K ≤ 100), K(1 ≤ K ≤ 100,000)
 * 1> K개의 소수가 오름차순
 * => 소수의 곱을 나열했을 때, N번째 오는 것을 출력
 * 
 * sol)
 * 우선순위큐에 다 담아두고 하나씩 꺼내면서 곱을 구하고 큐에 넣는 과정을 반복
 * 중복된 수 처리..
 * => 큐에서 꺼낸 값을 입력받은 소수들과 나누어 보면서, 나누어 떨어지는 수까지만 넣으면 됩
 */

public class Main {
	static int K, N;
	static long ans;
	static long[] primeNum;
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
 
        primeNum = new long[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            primeNum[k] = Long.parseLong(st.nextToken());
            pq.offer(primeNum[k]);
        }
 
        while (N-- > 0) {
            ans = pq.poll();
 
            for (int k = 0; k < K; k++) {
                if ((ans * primeNum[k]) >= ((long) 2 << 30)) {
                    break;
                }
                
                pq.offer(ans * primeNum[k]);
                if (ans % primeNum[k] == 0) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}