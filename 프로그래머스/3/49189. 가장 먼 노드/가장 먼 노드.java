import java.util.*;
import java.io.*;

class Solution {
    public int solution(int N, int[][] edge) {
        List<Integer>[] adjList = new ArrayList[N+1];
        
        for(int i=0; i<N+1; i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] go : edge){
            adjList[go[0]].add(go[1]);
            adjList[go[1]].add(go[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int[] vis = new int[N+1];
        vis[1] = 1;
        int max = Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i=0; i<adjList[cur].size(); i++){
                int next = adjList[cur].get(i);
                if(vis[next]==0){
                    q.add(next);
                    vis[next] = vis[cur]+1;
                    max = Math.max(max, vis[next]);
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<N+1; i++){
            if(vis[i] == max) ans++;
        }
        return ans;
    }
}