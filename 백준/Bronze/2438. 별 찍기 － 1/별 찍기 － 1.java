import java.io.*;
import java.util.*;

public class Main {
	static int N;
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<=i; j++) {
    			sb.append("*");
    		}
    		sb.append("\n");
    	}
    	System.out.print(sb.toString());
    }
}