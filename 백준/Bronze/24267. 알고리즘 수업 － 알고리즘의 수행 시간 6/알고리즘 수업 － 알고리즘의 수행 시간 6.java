import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * 1> n (1 ≤ n ≤ 500,000)
 * => 수행 횟수, 다항식으로 나타내었을 때, 최고차항의 차수
 * 
 * sol)
 * 어떤 N이 입력으로 들어오면 N^3의 수행시간 소요
 * 고정된 출력값
 * i와 같지 않고 큰 j를 선택하고, k도 j와 같지않고 큰 값을 선택한다 -> N개중 3개를 선택하는 조합
 * nCr = N! / ((N-R)! * R!) = nPr/R!
 * 
 * R=3 대입
 * => N*(N-1)*(N-2) / 3*2*1
 */

public class Main{
	static long N;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		
//		 // 시간초과
//		for(int i=1; i<=N-2; i++) {
//			for(int j=i+1; j<=N-1; j++) {
//				for(int k=j+1; k<=N; k++) {
//					cnt+=1;
//				}
//			}
//		}
		
		System.out.println(((N*(N-1)*(N-2))/6)+"\n3");
	}
}