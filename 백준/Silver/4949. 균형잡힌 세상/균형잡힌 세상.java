import java.util.*;
import java.io.*;

public class Main{
	static String tmp;
	static char[] stack;
	static int pointer=0;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		tmp = br.readLine();
		sb = new StringBuilder();
		while(!tmp.equals(".")) {
			stack = new char[101];
			pointer=0;
			boolean flag = true;
			for(char c : tmp.toCharArray()) {
				if(c=='(' || c=='[') {
					stack[pointer] = c;
					pointer+=1;
				}else if(c==')') {
					if(pointer>0 && stack[pointer-1]=='(') {
						pointer-=1;
					}else {
						flag = false;
						break;
					}
				}else if(c==']') {
					if(pointer>0 && stack[pointer-1]=='[') {
						pointer-=1;
					}else {
						flag = false;
						break;
					}
				}
			}
			if(flag && pointer==0) {
				sb.append("yes").append("\n");
			}else {
				sb.append("no").append("\n");
			}
			tmp = br.readLine();
		}
		System.out.println(sb);
	}
}