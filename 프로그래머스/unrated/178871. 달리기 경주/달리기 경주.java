import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        int order = 0;
        for(String player : players){
            map.put(player, order++);
        }
        
        for(String call : callings){
            int idx = map.get(call);
            if(idx != 0){
                String pre = players[idx-1];
                players[idx-1] = call;
                map.put(call, idx-1);
                players[idx] = pre;
                map.put(pre, idx);
            }
            
        }
        
        return players;
    }
}