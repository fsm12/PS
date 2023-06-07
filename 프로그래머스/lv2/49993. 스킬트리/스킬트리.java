/*

*/
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i), i+1);
        }
        
        for(String cs : skill_trees){
            int order = 0;
            for(int i=0; i<cs.length(); i++){
                char cur = cs.charAt(i);
                if(map.containsKey(cur)){
                    if(order + 1 == map.get(cur)){
                        order+=1;
                    }else{
                        answer-=1;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}