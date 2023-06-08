import java.util.*;

class Solution {
    List<Integer>[] adjList;
    boolean[] vis;
    int answer;
    
    public int solution(int N, int[][] wires) {
        answer = N;
        
        adjList = new ArrayList[N+1];
        for(int n=0; n<=N; n++){
            adjList[n] = new ArrayList();
        }
        
        vis = new boolean[N + 1];
        
        for(int i = 0; i < wires.length; i++) {
            adjList[wires[i][0]].add(wires[i][1]);
            adjList[wires[i][1]].add(wires[i][0]);
        }
        
        dfs(N, 1);
        return answer;
    }

    public int dfs(int N, int index) {
        vis[index] = true;
        int res = 0, total = 1;
        for(int i=0; i<adjList[index].size(); i++) {
            int node = adjList[index].get(i);
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            res = dfs(N, node);
            answer = Math.min(answer, Math.abs(N - 2* res));
            total += res;
        }
        return total;
    }
}