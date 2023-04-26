import java.util.*;
import java.io.*;

// 약수 개수가 홀수여야 1이 됨

public class Main{
	static int N;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		System.out.println((int)Math.floor(Math.sqrt(N)));
	}
}