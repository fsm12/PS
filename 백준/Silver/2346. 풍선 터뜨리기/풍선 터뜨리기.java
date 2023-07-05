import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] balloon;
	static Deque<Integer> deque;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		balloon = new int[N];
		for(int n=0; n<N; n++) {
			balloon[n] = Integer.parseInt(st.nextToken());
		}
		
		deque = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			deque.addLast(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int idx = deque.pollFirst();
			sb.append(idx+1).append(" ");

			if(deque.isEmpty())
				break;
			
			int cnt = balloon[idx];
			for(int i=0; i<cnt-1; i++) {
				deque.addLast(deque.pollFirst());
			}
			
			for(int i=0; cnt<i; i--) {
				deque.addFirst(deque.pollLast());
			}
		}
		System.out.println(sb);
    }
}