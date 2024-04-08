/*

*/

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
            int cIdx = q.poll();
            
            boolean flag = false;
            for(int next : adjList[cIdx]){
                // 방문 안한 곳 갈 수 있음
                if(!vis[next]){
                    q.add(next);
                    vis[next] = true; 
                    ansVal = Math.max(ansVal, 1);
                }
                
                // 방문했더라도 이어진 간선에서 아직 방문안한 곳이 있다면 갈 수 있음
                // +) 방문했더라도 이어진 간선이 2개이상 있다면 8자임
                if(vis[next]){
                    if(adjList[next].size()==2){
                    //for(int nnext : adjList[next]){
                        //if(!vis[nnext]){
                            //q.add(nnext);
                            ansVal = Math.max(ansVal, 2);
                            ans[3]+=1;
                            return;
                        //}
                    }else if(adjList[next].size()==0){
                        ans[2]+=1;
                        return;
                    }
                }
            }
        }
        
        switch(ansVal){
            case 1:
                if(vis[idx]){
                    ans[1]+=1;
                }else{
                   ans[2]+=1; 
                }
                break;
            case 2:
                
                break;
        }
    }
}

// class Node{
//     int idx;
//     int nodeVis;
    
//     public Node(int idx, int nodeVis){
//         this.idx = idx;
//         this.vis = nodeVis;
//     }
// }