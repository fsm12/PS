import java.util.*;
import java.io.*;


public class Main{
	static String inp;
	static int a,min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		inp = br.readLine();
		for(int i=0; i<inp.length(); i++) {
			if(inp.charAt(i) =='a') {
				a++;
			}
		}
		
		for(int i=0; i<inp.length(); i++) {
			int b = 0;
			for(int j=i; j<i+a; j++) {
				int idx = j%inp.length();
				if(inp.charAt(idx) =='b') {
					b++;
				}
			}
			min = Math.min(min, b);
		}
		bw.append(min+"");
		bw.flush();
	}
}