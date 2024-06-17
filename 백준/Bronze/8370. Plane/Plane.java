import java.util.*;
import java.io.*;

public class Main {
	static int n1,k1,n2,k2;
	static int ans;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n1 = Integer.parseInt(st.nextToken());
		k1 = Integer.parseInt(st.nextToken());
		n2 = Integer.parseInt(st.nextToken());
		k2 = Integer.parseInt(st.nextToken());
		
		
		ans = n1*k1 + n2*k2;
		System.out.println(ans);
	}
}