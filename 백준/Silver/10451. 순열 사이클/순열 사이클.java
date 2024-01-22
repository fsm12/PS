import java.io.*;
import java.util.*;

public class Main{
	static int T,N,ans;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			
			parents = new int[N+1];
			for(int n=0; n<=N; n++) {
				parents[n] = n;
			}
	
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans=0;
			for(int n=1; n<=N; n++) {
				int inp = Integer.parseInt(st.nextToken());
				union(n, inp);
			}
			sb.append(ans).append("\n");
		}	
		System.out.print(sb.toString());
	}
	
	public static int find(int a) {
		if(parents[a]==a){
            return a;
        }else{
            return parents[a] = find(parents[a]);
        }
	}
	
	public static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);
        
        if(ar==br) {
        	ans++;
		}else if(ar>br) {   
			parents[ar]= br;
		}else {
			parents[br] = ar;
		}
	}
}