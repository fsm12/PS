import java.util.*;
import java.io.*;

/*
 * 1 3 7 13
 * 2 4 6
 */

public class Main{
	static int N;
	static Set<Integer> origin;
	static List<Integer> pos, dist;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		pos = new ArrayList<>();
		origin = new HashSet<>();
		for(int n=0; n<N; n++) {
			int inp = Integer.parseInt(br.readLine());
			pos.add(inp);		
			origin.add(inp);
		}

		Collections.sort(pos);
		
		dist = new ArrayList<>();
		for(int n=1; n<N; n++) {
			dist.add(pos.get(n)-pos.get(n-1));
		}
		
		int interval = gcd(dist.get(0), dist.get(1));
		for(int n=2; n<N-1; n++) {
			interval = gcd(interval, dist.get(n));
		}
		
		System.out.println((pos.get(N-1)-pos.get(0))/interval-(N-1));		
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
}