import java.util.*;
import java.io.*;

public class Main{
	static int N, pointer;
	static int[] stack;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
		
		stack = new int[10001];
		pointer = 0;
		
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			if(word.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				stack[pointer] = X;
				pointer+=1;
			}else if(word.equals("pop")) {
				pointer-=1;
				if(pointer<0) {
					pointer=0;
					sb.append(-1).append("\n");
				}else {
					sb.append(stack[pointer]).append("\n");
				}
			}else if(word.equals("size")) {
				sb.append(pointer).append("\n");
			}else if(word.equals("empty")) {
				if(pointer==0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(word.equals("top")) {
				if(pointer-1<0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(stack[pointer-1]).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}