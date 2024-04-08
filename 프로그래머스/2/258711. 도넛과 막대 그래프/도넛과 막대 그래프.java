import java.util.*;
import java.io.*;

class Solution {
    static final int SIZE = 1000000;
    static int N=0;
    static List<Integer>[] adjList;
    static int[] ans;
    
    public int[] solution(int[][] edges) {
        ans = new int[4];
        
        adjList = new ArrayList[SIZE+1];
        for(int i=1; i<=SIZE; i++){
            adjList[i] = new ArrayList<>();
        }
        
        boolean[] out = new boolean[SIZE+1];
        for(int[] edge : edges){
            int s = edge[0];
            int e = edge[1];
            adjList[s].add(e);
            N = Math.max(N, Math.max(e,s));
            out[e] = true;
        }
        
        for(int i=1; i<=N; i++){
            if(!out[i] && 2<=adjList[i].size()){
                ans[0] = i;
                break;
            }
        }
        
        for(int idx : adjList[ans[0]]){
            bfs(idx);
        }
        
        return ans;
    }
    
    public static void bfs(int idx){
        if(adjList[idx].size()==0){
            ans[2]+=1;
            return;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        boolean[] vis = new boolean[N+1];
        
        int ansVal = 0;
        
        exit : while(!q.isEmpty()){
            int cur = q.poll();
            
            boolean flag = false;
            for(int next : adjList[cur]){
                if(!vis[next]){
                    q.add(next);
                    vis[next] = true; 
                    ansVal = Math.max(ansVal, 1);
                }
                
                if(vis[next]){
                    if(adjList[next].size()==2){
                        ansVal = Math.max(ansVal, 2);
                        ans[3]+=1;
                        return;
                    }else if(adjList[next].size()==0){
                        ans[2]+=1;
                        return;
                    }
                }
            }
        }
        ans[1]+=1;
        return;
    }
}
