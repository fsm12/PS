import java.util.*;

class Solution {
    public int[] solution(String s) {
        // int[] index_arr = new int[26];
        // Arrays.fill(index_arr, -1);
        
        Map<Character,Integer> map = new HashMap<>();
        
        
        int len = s.length();
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            Character cur = s.charAt(i);
            Integer get_idx = map.get(cur);
            if(get_idx == null){
                map.put(cur, i);
                answer[i] = -1;
            }else{
                answer[i] = i - get_idx;
                map.put(cur, i);

            }
        }
        return answer;
    }
}