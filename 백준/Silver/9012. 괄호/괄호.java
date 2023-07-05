import java.util.*;
import java.io.*;

public class Main{
	static int N,pointer;
	static boolean[] stack;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		while(N-->0) {
			stack = new boolean[51];
			pointer = 0;
			
			String tmp = br.readLine();
			boolean flag = true;
			exit : for(int i=0; i<tmp.length(); i++) {
				char c = tmp.charAt(i);
				if(c=='(') {
					stack[pointer] = true;
					pointer+=1;
				}else {
					if(pointer>0 && stack[pointer-1]) {
						pointer-=1;
					}else {
						flag = false;
						break exit;
					}
				}
			}
			if(flag&&pointer==0) {
				sb.append("YES").append("\n");
			}else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
}