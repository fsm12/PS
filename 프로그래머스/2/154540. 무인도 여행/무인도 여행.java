import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        vis = new boolean[N][M];
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!vis[i][j] && maps[i].charAt(j)!='X'){
                    list.add(bfs(i,j,maps));
                    // printMap(maps);
                }
            }
        }
        
        int[] ans;
        if(list.size()!=0){
            Collections.sort(list);
        
            ans = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                ans[i] = list.get(i);
            }
        }else{
            ans = new int[]{-1};
        }
        return ans;
    }
    
    public static int bfs(int x, int y, String[] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        vis[x][y] = true;
        
        int ans = 0;
        while(!q.isEmpty()){
            Point xy = q.poll();
            
            // System.out.println(xy.x +" "+ xy.y +" "+ (maps[xy.x].charAt(xy.y)+""));
            
            ans += Integer.parseInt(maps[xy.x].charAt(xy.y)+"");
            for(int i=0; i<4; i++){
                int nx = xy.x+dx[i];
                int ny = xy.y+dy[i];
                
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(!vis[nx][ny] && maps[nx].charAt(ny)!='X'){
                        vis[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            
            }
        }
            // System.out.println(ans);
        return ans;
    }
    
    // public static void printMap(String[] maps){
    //     StringBuilder sb = new StringBuilder();
    //     for(int i=0; i<N; i++){
    //         for(int j=0; j<M; j++){
    //             sb.append(maps[i].charAt(j) +"\t");
    //         }
    //         sb.append("\n");
    //     }
    //     sb.append("\n");
    //     System.out.println(sb.toString());
    // }
}

class Point{
    int x,y;
    
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}