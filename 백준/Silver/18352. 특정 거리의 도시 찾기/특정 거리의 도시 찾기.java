import java.io.*;
import java.util.*;

public class Main {
    static int n,m,k,x;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<Integer>[] edges = new List[n+1];
        for (int i = 1; i <= n; i++) 
            edges[i] = new ArrayList<>();
            
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }

        dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(x);
        dist[x] = 0;

        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (dist[cur] > k) 
                break;
            if (dist[cur] == k) 
                answer.add(cur);

            for (int next : edges[cur]) {
                if (dist[next] != -1) 
                    continue;
                dist[next] = dist[cur]+1;
                q.add(next);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int cur : answer) {
            sb.append(cur).append('\n');
        }
        System.out.print(answer.isEmpty() ? -1 : sb);
    }
}