import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] swi;

    public static void main(String[] args) throws Exception {
    	// System.setIn(new FileInputStream("src/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	swi = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int n=0; n<N; n++) {
    		swi[n] = Integer.parseInt(st.nextToken());
    	}
    	
    	M = Integer.parseInt(br.readLine());
    	for(int m=0; m<M; m++) {
        	st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		if(a==1) {
    			for(int i=b; i<=N; i+=b) {
        			swi[i-1] = 1-swi[i-1];
    			}
    		}else if(a==2) {
    			int surr=0;
    			for(int j=1; j<N; j++) {
    				if(0<=b-j-1 && b-j-1<N && 0<=b+j-1 && b+j-1<N && swi[b-j-1] == swi[b+j-1]) {
    					surr++;
    					continue;
    				}
    				break;
    			}
    			for(int i=1; i<=surr; i++) {
        			swi[b-i-1] = 1-swi[b-i-1];
        			swi[b+i-1] = 1-swi[b+i-1];
    			}
    			swi[b-1] = 1-swi[b-1];
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		if(i!=0 && i%20==0)
    			sb.append("\n");
    		sb.append(swi[i]).append(" ");
    	}
    	System.out.println(sb.toString());
    	
    }
}