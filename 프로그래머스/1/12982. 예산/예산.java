import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int ans=0, sum=0; 

        Arrays.sort(d);       
        
        for(int di : d){
            sum+=di;
            if(sum <= budget)
                ans+=1;
            else
                break;
        }
        return ans;
    }
}