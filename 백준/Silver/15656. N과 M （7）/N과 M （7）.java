import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr, printArr;
    static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
            // System.setIn(new FileInputStream("input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
            StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
		    st = new StringTokenizer(br.readLine());
			for(int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
            sb = new StringBuilder();
			printArr = new int[M];
			dfs(0, 0);
			
			System.out.println(sb);
	}
	
	static void dfs(int start, int depth) {
		if(depth == M) {
			for(int m=0; m<M; m++) {
				sb.append(printArr[m]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int n=0; n<N; n++) {
			printArr[depth] = arr[n];
			dfs(n+1, depth+1); 
		}
	}
}