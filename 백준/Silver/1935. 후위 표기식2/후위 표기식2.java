import java.io.*;
import java.util.*;

public class Main {
    static int N, point=0;
    static String inp;
    static int[] alpha;
    static Stack<Double> stack;
    static double a;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		N = Integer.parseInt(br.readLine());

		inp = br.readLine();
		
		alpha = new int[N];
		for(int n=0; n<N; n++) {
			alpha[n] = Integer.parseInt(br.readLine());
		}
		
		stack = new Stack<>();
		for(int i=0; i<inp.length(); i++) {
			char c = inp.charAt(i);
			switch(c) {
			case '*':
				stack.add(stack.pop() * stack.pop());
				break;
			case '+':
				stack.add(stack.pop() + stack.pop());
				break;
			case '/':
				a = stack.pop();
				stack.add(stack.pop() / a);
				break;
			case '-':
				a = stack.pop();
				stack.add(stack.pop() - a);
				break;
			default:
				stack.add((double) alpha[c-'A']);
			}
		}
		
		bw.write(String.format("%.2f", stack.pop()));
		bw.flush();
    }
}