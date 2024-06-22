import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
            
			int M = Integer.parseInt(br.readLine());
            
			int[] dp = new int[1000001];
			Arrays.fill(dp, Integer.MAX_VALUE);
            
			if(contains(1,arr)) {
				dp[1] = 0;
			}else {
				dp[1] = -1;
			}
            
			for (int i = 0; i < M; i++) {
				int K = Integer.parseInt(br.readLine());
				sb.append(findMultiplyCnt(K,dp,arr));
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static int findMultiplyCnt(int x, int[] dp, int[] arr) {
		if(dp[x] != Integer.MAX_VALUE) 
            return dp[x];
		if(canMakeWithoutMultiply(x,arr)) {
			dp[x] = 0;
			return dp[x];
		}else {
			List<Integer> lst = divisor(x);
			for (int i = 0; i < lst.size(); i++) {
				int num = lst.get(i);
				int pairNum = x/num;
                
				if(num == 1) continue;
				if(dp[num] == Integer.MAX_VALUE) {
					dp[num] = findMultiplyCnt(num,dp,arr);
				}
				if(dp[pairNum] == Integer.MAX_VALUE) {
					dp[pairNum] = findMultiplyCnt(pairNum,dp,arr);
				}
				if(dp[num] == -1 || dp[pairNum] == -1) continue;
				dp[x] = Math.min(dp[x], dp[num] + dp[pairNum] + 1);
			}
			if(dp[x] == Integer.MAX_VALUE) {
				dp[x] = -1;
			}
			return dp[x];
		}
	}
	
	public static List<Integer> divisor(int x) {
		List<Integer> lst = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(x); i++) {
			if(x%i == 0) {
				lst.add(i);
			}
		}
		return lst;
	}
	
	public static boolean canMakeWithoutMultiply(int x, int[] arr) {
		String s = Integer.toString(x);
		for (int i = 0; i < s.length(); i++) {
			if(!contains(s.charAt(i)-'0',arr)) return false;
		}
		return true;
	}
	
	public static boolean contains(int x, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == x) return true;
		}
		return false;
	}
}