import java.util.*;
import java.io.*;

public class Main{
	static int N;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		System.out.println((N % 2 == 1) ? "SK" : "CY");
		
	}
}