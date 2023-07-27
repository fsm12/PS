import java.io.*;
import java.util.*;

public class Main {
	static int S, P, ans = 0;
	static String dna;
	static int[][] dp;
	static int[] acgt;
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	S = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	
    	dna = br.readLine();
    	
    	st = new StringTokenizer(br.readLine());
    	acgt = new int[4];
    	for(int i=0; i<4; i++) {
    		acgt[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	dp = new int[4][S+2];
    	int idx = 1;
    	for(char c : dna.toCharArray()) {
    		switch(c) {
    		case 'A':
    			dp[0][idx] += 1;
    			break;
    		case 'C':
    			dp[1][idx] += 1;
    			break;
    		case 'G':
    			dp[2][idx] += 1;
    			break;
    		case 'T':
    			dp[3][idx] += 1;
    			break;
    		}
    		idx++;
    		
    		dp[0][idx] += dp[0][idx-1];
    		dp[1][idx] += dp[1][idx-1];
    		dp[2][idx] += dp[2][idx-1];
    		dp[3][idx] += dp[3][idx-1];
    	}
    	
    	for(int i=1; i<S-P+2; i++) {
    		if(acgt[0] <= dp[0][i+P-1] - dp[0][i-1] && 
    				acgt[1] <= dp[1][i+P-1] - dp[1][i-1] && 
    				acgt[2] <= dp[2][i+P-1] - dp[2][i-1] && 
    				acgt[3] <= dp[3][i+P-1] - dp[3][i-1]) {
    			ans++;
    		}
    	}
    	bw.append(String.valueOf(ans));
    	bw.flush();
    }
}

