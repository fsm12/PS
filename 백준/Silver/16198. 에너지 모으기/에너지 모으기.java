import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long ans;
	static List<Integer> w;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		w = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=1; n<=N; n++) {
			w.add(Integer.parseInt(st.nextToken()));
		}
		
		getEnergy(N, w, 0);
		System.out.println(ans);
	}
	
	public static void getEnergy(int depth, List<Integer> curWeight, long sum) {
		if(depth==2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=1; i<depth-1; i++) {
			List<Integer> tmp = new ArrayList<>(curWeight);
			tmp.remove(i);
			getEnergy(depth-1, tmp, sum + curWeight.get(i-1) * curWeight.get(i+1));
		}
	}
}