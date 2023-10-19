import java.util.*;
import java.io.*;

public class Main {
	static int N, ans=0;
	static int[] levels;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		
		int[] levels = new int[N];
		for(int i = 0; i < N; i++) {
			levels[i] = Integer.valueOf(br.readLine());
		}
		
		ans = 0;
		if(N!=1) {
			for(int i=N-2; i>=0; i--) {
				int h = levels[i+1];
				int l = levels[i];
				if(l>=h) {
					ans += l-h+1;
					levels[i] = h-1;
				}
			}
		}
		System.out.print(ans);
	}
}