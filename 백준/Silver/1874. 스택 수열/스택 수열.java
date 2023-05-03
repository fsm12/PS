import java.util.*;
import java.io.*;

public class Main{
	static int N,s,inp;
	static Stack<Integer> stack;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		
		stack = new Stack<>();
		sb = new StringBuilder();
		while(N -- > 0) {
			inp = Integer.parseInt(br.readLine());
			if(s<inp) {
				for(int i = s + 1; i <= inp; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				s = inp;
			} else if(stack.peek() != inp) {
				System.out.println("NO");
				return;
			}
			
			stack.pop();
			sb.append('-').append('\n');
			
		}
		
		System.out.println(sb);
	}
}