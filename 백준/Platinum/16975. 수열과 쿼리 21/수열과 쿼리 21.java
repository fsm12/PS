import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
    static int[] arr;
    static long[] tree;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        tree = new long[4*N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while (M-->0) {
            st = new StringTokenizer(br.readLine());
            
            int std = Integer.parseInt(st.nextToken());
            if (std==1) {
                int i = Integer.parseInt(st.nextToken());
                int	j = Integer.parseInt(st.nextToken());
                int	k = Integer.parseInt(st.nextToken());
                update(1, N, 1, i, k);
                update(1, N, 1, j+1, -k);
            } else {
                int v = Integer.parseInt(st.nextToken());
                long result = getSum(1, N, 1, 1, v) + arr[v];
                sb.append(result).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    private static long getSum(int left, int right, int node, int u, int v) {
        if (v < left || right < u) 
        	return 0;
        else if (u <= left && right <= v) 
        	return tree[node];
        
        int mid = (left + right) / 2;
        return getSum(left, mid, node * 2, u, v) + getSum(mid + 1, right, node * 2 + 1, u, v);  
    }

    private static long update(int left, int right, int node, int i, int k) {
        if (left <= i && i <= right) {
            if (left == right) 
            	return tree[node] += k;
            
            int mid = (left + right) / 2;
            tree[node] = update(left, mid, node * 2, i, k) + update(mid + 1, right, node * 2 + 1, i, k);
        }
        return tree[node];
    }
}