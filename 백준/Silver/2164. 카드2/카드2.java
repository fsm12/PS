import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        for(int n=1; n<=N; n++) {
        	q.add(n);
        }
        
        while(q.size()>1) {
        	q.poll();
        	q.offer(q.poll());
        }
        System.out.println(q.poll());
	}
}