import java.util.*;
import java.io.*;

/*
 * 문제)
 * 성냥개비를 모두 사용해서 만들 수 있는 가장 작은 수와 가장 큰 수 출력 (0시작 불가)
 * 
 * 풀이)
 * 가장 작은 수는 "적은 자릿수"를 가지거나 "앞자리가 작은 수"임
 * 가장 큰 수는 "긴 자릿수"를 가지거나, "앞자리가 큰 수" 
 * 
 *  7개 사용 : 8
 * 	6개 사용 : 0, 6
 *  5개 : 2, 3, 5
 *  4개 : 4
 *  3개 : 7
 *  2개 : 1
 * 
 * sol) 
 * 숫자 : 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
 * 개수 : 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 
 * 
 * 가장 작은 수 : 성냥개비를 많이 사용하는 작은 숫자를 사용 
 * 가장 큰 수 : 2로 나누어 떨어지면 1만, 나누어 떨어지지 않으면 앞에 7 붙이기
 */

public class Main{
	static int T,N;
	static long[] minDp;

	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		minDp = new long[101];
		Arrays.fill(minDp, Long.MAX_VALUE);
		minDp[2]=1;
		minDp[3]=7;
		minDp[4]=4;
		minDp[5]=2;
		minDp[6]=6;
		minDp[7]=8;
		minDp[8]=10;
		
		String[] add = {"1","7","4","2","0","8"};
		for(int i=9;i<=100;i++) {
			for(int j=2;j<=7;j++) {
				String line = minDp[i-j]+add[j-2];
				minDp[i] = Math.min(Long.parseLong(line), minDp[i]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			sb.append(minDp[N]).append(" ");
			if(N%2==1) {
				N-=3;
				sb.append(7);
			}
			while(N>=2) {
				N-=2;
				sb.append(1);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}