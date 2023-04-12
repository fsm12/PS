import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> N (1 ≤ N ≤ 1,000,000,000)
 * => 자리수를 내림차순으로 정렬한 수를 출력
 * 
 */

public class Main{
	static String tmp;
	static char[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		tmp = br.readLine();
		arr = new char[tmp.length()];
		
		int i=0;
		for(char c : tmp.toCharArray()) {
			arr[i] = c;
			i+=1;
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int n=tmp.length()-1; n>=0; n--) {
			sb.append(arr[n]);
		}
		System.out.println(sb);
		
	}
}