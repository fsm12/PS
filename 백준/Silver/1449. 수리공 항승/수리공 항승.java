import java.io.*;
import java.util.*;

public class Main{
	static int N,L,ans=0;
	static List<Integer> locArr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		locArr = new ArrayList<>();
		while(st.hasMoreTokens()) {
			locArr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(locArr);
		
		int curMax = 0;
		for(int i=0; i<locArr.size(); i++) {
			if(curMax<locArr.get(i)) {
				ans+=1;
				curMax=locArr.get(i)+L-1;
			}
		}
		System.out.println(ans);
	}
}