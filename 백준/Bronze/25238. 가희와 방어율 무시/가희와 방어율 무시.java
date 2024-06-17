import java.util.*;
import java.io.*;

public class Main {
	static int a,b;
	static double ans;
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		ans = a-(((double)(a*b))/100);
		
		System.out.println(ans<100?1:0);
	}
}