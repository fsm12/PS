import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            sum+=1;
            Integer val = map.get(num);
            if(val == null){
                map.put(num,1);
                continue;
            }
            map.put(num, val+1);
        }
        
        int ans = map.size();
        if(sum/2 < map.size()){
            ans = sum/2;
        }
        return ans;
    }
}