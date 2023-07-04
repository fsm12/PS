import java.io.*;
import java.util.*;

public class Main{
	static int N,K;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();
		for(int n=1; n<=N; n++){
			q.add(n);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()){
			for(int k=0; k<K-1; k++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}