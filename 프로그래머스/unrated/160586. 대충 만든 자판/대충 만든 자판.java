import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] min_push = new int[26];
        Arrays.fill(min_push, Integer.MAX_VALUE);
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                int idx = keymap[i].charAt(j)-'A';
                min_push[idx] = Math.min(min_push[idx], j+1);
            }
        }
        
        int[] ans = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            for(char c : targets[i].toCharArray()){
                int cnt = min_push[c-'A'];
                if(cnt == Integer.MAX_VALUE){
                    ans[i] = -1;
                    break;
                }
                ans[i] += cnt;
            }
        }
        
        return ans;
    }
}