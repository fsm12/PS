import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static int[] arr;
	static Set<Long> set;
    
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());   
        K = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        for(int n=0; n<N; n++) {
        	arr[n] = Integer.parseInt(br.readLine());
        }
        
        set = new HashSet<>();
        nCr(0,new boolean[N], new StringBuilder());

        System.out.println(set.size());
    }
    
    public static void nCr(int depth, boolean[] vis, StringBuilder sb) {
    	if(K<depth) {
    		return;
    	}
    	
    	if(K == depth) {
    		Long cur = Long.parseLong(sb.toString());
    		if(!set.contains(cur))
    			set.add(cur);
    		return;
    	}
    	
    	for(int i=0; i<N; i++) {
    		if(!vis[i]) {
	    		StringBuilder sbNew = new StringBuilder(sb.toString());
	    		sbNew.append(arr[i]);
	    		vis[i] = true;
	    		nCr(depth+1, vis, sbNew);
	    		vis[i] = false;
    		}
    	}
    }
}