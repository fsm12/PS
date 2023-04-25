import java.util.*;
import java.io.*;

/*
에라토스테네스의체 => 배열 크기설정이 까다로움
소수인지 판단하며 1증가 형태로 구현하자
*/

public class Main {
	static long T,N;
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Long.parseLong(br.readLine());
		
		for(long t = 0; t < T; t++) {
			N = Long.parseLong(br.readLine());
			while(true) {
				if(isPrime(N)) {
					sb.append(N).append("\n");
					break;
				}else {
					N+=1;
				}
			}
		}
		System.out.print(sb);

	}
	
	public static boolean isPrime(long n) {
		if(n<2)
			return false;
		for(long i=2; i<(long)(Math.sqrt(n))+1; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}