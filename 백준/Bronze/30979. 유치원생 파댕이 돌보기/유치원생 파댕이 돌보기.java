import java.io.*;
import java.util.*;

public class Main {
	static int T,N;
	static int[] fSum;
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	T = Integer.parseInt(br.readLine());
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	fSum = new int[N+1];
    	for(int f=1; f<=N; f++) {
    		fSum[f] += Integer.parseInt(st.nextToken()) + fSum[f-1];
    	}
    	System.out.print(T<=fSum[N]?"Padaeng_i Happy":"Padaeng_i Cry");
    }
}