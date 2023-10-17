import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] v,a,tree;
	
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        v = new int[N+1];
        a = new int[N+1];
        tree = new int[1<<20];
        for (int i=1; i<=N; i++) {
            v[i] = Integer.parseInt(br.readLine());
            a[i] = v[i];
        }
        
        Arrays.sort(v);
        
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            a[i] = Arrays.binarySearch(v, a[i]) + 1;
            sb.append(i - query(1,1,N,1,a[i]-1)).append("\n");
            update(1,1,N,a[i],1);
        }
        System.out.print(sb.toString());
    }

    static int query(int node, int s, int e, int left, int right) {
        if (e < left || right < s)
            return 0;
        if (left <= s && e <= right)
            return tree[node];
        int mid = (s+e)/2;
        return query(node*2, s, mid, left, right) + query(node*2+1, mid+1, e, left, right);
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (e < idx || idx < s)
            return;
        tree[node] += val;
        if (s!=e) {
            int mid = (s+e)/2;
            update(node*2, s, mid, idx, val);
            update(node*2+1, mid+1, e, idx, val);
        }
    }
}