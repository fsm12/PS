import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : X.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        int zero_cnt = 0;
        for(char c : Y.toCharArray()){
            Integer cnt = map.get(c);
            if(cnt != null && 0 < cnt){
                pq.add(c);
                map.put(c, cnt-1);
                if(c == '0')
                    zero_cnt++;
            }
        }
        
        if(pq.size()!=0 && zero_cnt == pq.size())
            return "0";
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while(!pq.isEmpty()){
            flag = true;
            sb.append(pq.poll());
        }
        return flag?sb.toString():"-1";
    }
}