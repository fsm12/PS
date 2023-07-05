import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String parti : participant){
            map.put(parti,map.getOrDefault(parti,0)+1);
        }
        
        for(String com : completion){
            Integer cnt = map.get(com);
            map.put(com, cnt-1);
        }
        
        String ans = "";
        for(String key : map.keySet() ){
            if(0 < map.get(key)){
                ans = key;
                break;
            }
        }
        return ans;
    }
}