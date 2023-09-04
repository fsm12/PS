import java.util.*;
import java.io.*;

public class Main{
	static int N,K,del=0,p=0;
	static char[] stack;
	static String num;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
 
		num = br.readLine();
		stack = new char[N];
		for (int i = 0; i < N; i++) {
            while (del < K && p!=0 && Integer.valueOf(stack[p-1]) < Integer.valueOf(num.charAt(i))) {
                p-=1;
                del++;
            }
            stack[p++] = num.charAt(i);
        }
		
		StringBuilder sb = new StringBuilder();
        for(int i=0; i<N-K; i++){
            sb.append(stack[i]);
        }
		System.out.println(sb.toString());
	}
}