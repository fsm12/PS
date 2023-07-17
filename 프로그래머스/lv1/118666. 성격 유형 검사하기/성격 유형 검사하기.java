import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        
        int N = survey.length;
        for(int n=0; n<N; n++){
            if(choices[n] == 0)
                continue;
            if(choices[n] < 4){
                char c = survey[n].charAt(0);
                map.put(c, map.getOrDefault(c, 0) + 4-choices[n]);
            }else{
                char c = survey[n].charAt(1);
                map.put(c, map.getOrDefault(c, 0) + choices[n]-4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++){
            sb.append(choose_type(map, i*2));
        }
        
        return sb.toString();
    }
    
    public static char choose_type(Map<Character, Integer> map, int std){
        char[] type = new char[]{'R','T','C','F','J','M','A','N'};
        
        int firCnt = map.getOrDefault(type[std], 0);
        int secCnt = map.getOrDefault(type[std+1], 0);
        
        if(secCnt <= firCnt)
            return type[std];
        return type[std+1];
    }
}