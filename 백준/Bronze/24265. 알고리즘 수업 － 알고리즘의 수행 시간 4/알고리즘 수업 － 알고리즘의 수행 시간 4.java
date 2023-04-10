import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * 1> n (1 ≤ n ≤ 500,000)
 * => 수행 횟수, 다항식으로 나타내었을 때, 최고차항의 차수
 * 
 * sol)
 * 어떤 N이 입력으로 들어오면 N^2의 수행시간 소요
 * 제곱을 할 경우 int범위를 초과함(주의)
 * 2~7 = 6
 * i=1 -> j=2~N (N-1)
 * i=2 -> j=3~N (N-2)
 * ...
 * i=N-1 -> j=N (N=1)
 * => N-1 + N-2 + ... 1(N-(N-1)) == N(N-1)/2
 * 
 * 고정된 출력값
 */

public class Main{
	static long N;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Long.parseLong(br.readLine());
		
		System.out.println((N*(N-1)/2)+"\n2");
	}
}