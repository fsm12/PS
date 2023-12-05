import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int val=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='{' || c=='}')
                continue; 
            if(c==','){
                cntMap.put(val, cntMap.getOrDefault(val,0)+1);
                val=0;
                continue;
            }
            val = val*10 + Integer.parseInt(c+"");
        }
        cntMap.put(val, cntMap.getOrDefault(val,0)+1);
        
        int N = cntMap.size();
        int[] ans = new int[N];
        for(Integer key : cntMap.keySet()){
            ans[N-cntMap.get(key)] = key;
        }
        return ans;
    }
}