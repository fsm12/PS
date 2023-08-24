import java.util.*;
import java.io.*;

public class Main{
	static String inp;
	static char[] stack;
	static int len, p=0;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		inp = br.readLine();
		len = inp.length();
		
		stack = new char[len];
		for(char c : inp.toCharArray()) {
			if(1<p && stack[p-2]=='d' && stack[p-1] == 'z' &&  c=='=') {
				stack[p-2] = '*';
				p-=1;
				continue;
			}else if(0<p && ((stack[p-1]=='c' &&  c=='=') 
					|| (stack[p-1]=='c' &&  c=='-')
					|| (stack[p-1]=='d' &&  c=='-')
					|| (stack[p-1]=='l' &&  c=='j')
					|| (stack[p-1]=='n' &&  c=='j')
					|| (stack[p-1]=='s' &&  c=='=')
					|| (stack[p-1]=='z' &&  c=='='))) {
				stack[p-1] = '*';
				continue;
			}
			stack[p++] = c;
		}
		
		bw.append(String.valueOf(p));
		bw.flush();
	}

}