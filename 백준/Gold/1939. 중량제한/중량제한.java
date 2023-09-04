import java.util.*;
import java.io.*;

public class Main{
    static int N,M,S,E;
    static int left=0,right=0,max=0;
    static List<Island>[] adjList;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);
            
            adjList[a].add(new Island(b,c));
            adjList[b].add(new Island(a,c));
        }
        right = max;

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        while (left <= right) {
            vis = new boolean[N+1];

            int mid = (left+right)/2;
            if (bfs(S,E,mid)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(right);
    }

    private static boolean bfs(int S, int E, int mid) {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        vis[S] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == E) {
                return true;
            }

            for (Island island : adjList[cur]) {
                if (!vis[island.desti] && mid <= island.cost) {
                    vis[island.desti] = true;
                    q.add(island.desti);
                }
            }
        }
        return false;
    }

    static class Island {
        int desti, cost;

        public Island(int desti, int cost) {
            this.desti = desti;
            this.cost = cost;
        }
    }
}