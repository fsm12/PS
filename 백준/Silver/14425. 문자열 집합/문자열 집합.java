import java.util.*;
import java.io.*;

public class Main{
	static int N,M,ans;
	static Set<String> set;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		for(int n=0; n<N; n++) {
			set.add(br.readLine());
		}
		
		for(int m=0; m<M; m++) {
			if(set.contains(br.readLine())) {
				ans+=1;
			}
		}
		System.out.println(ans);
	}
}