import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] cnt = new int[number+1];
        Arrays.fill(cnt, 1);
        for(int i=2; i<=number; i++){
            for(int j=1; i*j<=number; j++){
                cnt[i*j]+=1;
            }
        }
        
        int ans = 0;
        for(int i=1; i<=number; i++){
            if(limit < cnt[i])
                ans += power;
            else
                ans += cnt[i];
        }
        return ans;
    }
}