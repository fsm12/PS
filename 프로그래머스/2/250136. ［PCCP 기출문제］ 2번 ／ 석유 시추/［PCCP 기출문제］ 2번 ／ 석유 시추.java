import java.util.*;

class Solution {
    static int N,M,idx;
    static boolean[][] vis;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static Map<Integer, Integer> oilMap;
    
    public int solution(int[][] land) {
        int ans = 0;
        N = land.length;
        M = land[0].length;
            
        oilMap = new HashMap<>();
        oilMap.put(0,0);
        
        vis = new boolean[N][M];
        idx = 2;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(land[n][m] == 1 && !vis[n][m]){
                    Queue<Space> q = new LinkedList<>();
                    int x = n;
                    int y = m;
                    
                    q.add(new Space(x,y));
                    vis[x][y] = true;
                    land[x][y] = idx;

                    int visCnt=1;
                    while(!q.isEmpty()){
                        Space cur = q.poll();

                        for(int i=0; i<4; i++){
                            int nx = cur.x+dx[i];
                            int ny = cur.y+dy[i];
                            if(0<=nx && nx<N && 0<=ny && ny<M){
                                if(land[nx][ny] == 1 && !vis[nx][ny]){
                                    vis[nx][ny] = true;
                                    q.add(new Space(nx,ny));
                                    land[nx][ny] = idx;
                                    visCnt +=1;
                                }
                            }
                        }
                    }
                    oilMap.put(idx, visCnt);
                    idx++;
                }
            }
        }
        
        for(int m=0; m<M; m++){
            int sum=0;
            Set<Integer> set = new HashSet<>();
            for(int n=0; n<N; n++){
                if(land[n][m] != 0 && land[n][m] != 1)
                set.add(land[n][m]);
            }
            for(Integer a : set){
                sum += oilMap.get(a);
            }
            ans = Math.max(sum, ans);
        }
       
        return ans;
    }
}

class Space{
    int x,y;
    
    public Space(int x, int y){
        this.x=x;
        this.y=y;
    }
}