import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] ans = new int[2];
        
        Map<Character, int[]> xy = new HashMap<>();
        xy.put('N', new int[]{-1,0});
        xy.put('S', new int[]{1,0});
        xy.put('W', new int[]{0,-1});
        xy.put('E', new int[]{0,1});
        
        int N = park.length, M = park[0].length();
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(park[n].charAt(m) == 'S'){
                    ans = new int[]{n,m};
                    break;
                }
            }
        }
        
        for(String route : routes){
            int[] dxdy = xy.get(route.charAt(0));
            int move = route.charAt(2) - '0';
            
            int nx = ans[0], ny = ans[1];
            for(int n=0; n<move; n++){
                nx+=dxdy[0];
                ny+=dxdy[1];
                if(0<=nx && nx<N && 0<=ny && ny<M && (park[nx].charAt(ny) == 'O' || park[nx].charAt(ny) == 'S')){
                    continue;
                }
                nx = ans[0];
                ny = ans[1];
                break;
            }
            ans[0] = nx;
            ans[1] = ny;
        }
        return ans;
    }
}