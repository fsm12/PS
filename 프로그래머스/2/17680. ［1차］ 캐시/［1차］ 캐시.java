import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length*5;
        
        LinkedList<String> cache = new LinkedList<>();
        int ans = 0;
        for(String s : cities){
            s = s.toUpperCase();
            if(cache.remove(s)){
                ans+=1;
            }else{
                ans+=5;
                if(cacheSize <= cache.size()){
                    cache.remove(0);
                }
            }
            cache.add(s);
        }
        return ans;
    }
}