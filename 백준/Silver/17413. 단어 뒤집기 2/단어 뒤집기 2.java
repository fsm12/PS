import java.io.*;
import java.util.*;

public class Main{
	static String str;
	static char[] stack;
	static int N,p=0;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
        
		StringBuilder sb= new StringBuilder();
		stack = new char[N+1];
		for(int i=0; i<N; i++) {
			char c = str.charAt(i);
			switch(c) {
			case '<':
				while(0<p) {
					sb.append(stack[--p]);
				}
				while(c!='>' && i<N) {
					c = str.charAt(i++);
					sb.append(c);
				}
				i-=1;
				break;
			case ' ':
				while(0<p) {
					sb.append(stack[--p]);
				}
				sb.append(' ');
				break;
			default:
				stack[p++]=str.charAt(i);
			}
		}
		while(0<p) {
			sb.append(stack[--p]);
		}
		System.out.println(sb.toString());
	}
}