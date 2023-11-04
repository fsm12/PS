import java.util.*;
import java.io.*;

public class Main {
    static int[] answer;
    static List<Integer>[] edges;
    static int idx = 0;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
        	edges[i] = new ArrayList<>();
        }
        
        answer = new int[n+1];
        v = new boolean[n+1];
        while (m-->0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) { 
        	Collections.sort(edges[i], Collections.reverseOrder());
        }
        
        v[r] = true;
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) 
        	sb.append(answer[i]).append('\n');
        
        System.out.print(sb);
    }
    
    public static void dfs(int cur) {
        answer[cur] = ++idx;
        for (int next : edges[cur]) {
            if (v[next]) 
            	continue;
            v[next] = true;
            dfs(next);
        }
    }
}