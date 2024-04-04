import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int ans =0;
        
        int[] cnt = new int[number+1];
        
        for(int i=1; i<=number; i++){
            for(int j=i; j<=number; j+=i){
                cnt[j] +=1;
            }
        }
        // for(int i=1; i<=number; i++){
        //     System.out.println(cnt[i]);
        // }
        
        for(int i=1; i<=number; i++){
            ans += limit<cnt[i]?power:cnt[i];
        }
        return ans;
    }
}