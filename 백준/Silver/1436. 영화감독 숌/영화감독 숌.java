import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> N (10,000보다 작거나 같은 자연수)
 * => N번째 영화의 제목에 들어간 수
 * 
 * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수
 */

public class Main{
	static int N, p=1;
	
	public static void main(String[] args) throws Exception{
        // System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		while (N!=0) {
			p+=1;
			if(String.valueOf(p).contains("666"))
				N-=1;
		}
		System.out.println(p);
	}
}