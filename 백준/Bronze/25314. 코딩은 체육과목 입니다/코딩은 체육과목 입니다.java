import java.util.*;
import java.io.*;

public class Main{
    static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<N/4; i++) {
			sb.append("long ");
		}
		sb.append("int");
        
		System.out.println(sb.toString());
	}
}