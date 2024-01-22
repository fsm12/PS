import java.io.*;
import java.util.*;

public class Main{
	static int cnt=0;
	static int[] zeroOne;
	static String str;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		zeroOne = new int[2];
		int cur = Integer.parseInt(String.valueOf(str.charAt(0)));
		zeroOne[cur] += 1;
		for(int i=1; i<str.length(); i++) {
			if(cur == Integer.parseInt(String.valueOf(str.charAt(i)))) {
				continue;
			}
			cur = Integer.parseInt(String.valueOf(str.charAt(i)));
			zeroOne[cur] += 1;
		}
		System.out.println(Math.min(zeroOne[0], zeroOne[1]));
	}
}