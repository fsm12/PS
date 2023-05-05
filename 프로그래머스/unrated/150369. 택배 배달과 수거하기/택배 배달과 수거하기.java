import java.util.*;

/*
배달해야할 곳 포인터 d, 회수해야할 곳 포인터 p라 하면 max(p,d)*2한 값이 한번 배달/회수할 때 이동해야할 거리임
배달할 물건을 너무 많이 들고와서 회수할때 배달 못한 물건을 들고있는 경우는 없음 (독립)

가장 먼 지점부터 보면서
    

*/

class Solution {
    public long solution(int cap, int N, int[] deliveries, int[] pickups) {
        long ans = 0;
        
        int d=cap, p=cap, start_point=N-1;
        for(int n = N-1; n >= 0; n--){
            d -= deliveries[n];
            p -= pickups[n];
            
            if(n==start_point && d==cap && p==cap){
                start_point-=1;
            }
            
            while(d<0 || p<0){
                d+=cap;
                p+=cap;
                ans += (n+1)*2;
            }

        }
        ans += (start_point+1)*2;
        return ans;
    }
}