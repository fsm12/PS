import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : win_nums){
            set.add(num);
        }
        
        int zero_cnt = 0, win_cnt = 0;
        for(int lotto : lottos){
            if(set.contains(lotto)){
                win_cnt++;
            }
            if(lotto == 0){
                zero_cnt++;
            }
        }
        
        int[] ans = new int[2];
        return new int[]{7-((win_cnt+zero_cnt==0)?1:(win_cnt+zero_cnt)), 7-(win_cnt==0?1:win_cnt)};
    }
}