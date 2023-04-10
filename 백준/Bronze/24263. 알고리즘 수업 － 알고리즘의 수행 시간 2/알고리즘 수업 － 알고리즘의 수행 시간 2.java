import java.util.*;
import java.io.*;

/*
 * 1 초	512 MB
 * 
 * 1> n (1 ≤ n ≤ 500,000)
 * => 수행 횟수, 다항식으로 나타내었을 때, 최고차항의 차수
 * 
 * sol)
 * 어떤 N이 입력으로 들어오면 N의 수행시간 소요
 * 고정된 출력값
 */

public class Main{
	static int N;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		System.out.println(N+"\n1");
	}
}