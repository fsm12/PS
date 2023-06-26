class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean isPossi = false;
        
        int cs1 = 0, cs2 = 0, len1 = cards1.length, len2 = cards2.length;
        for(String want : goal){
            if(cs1 < len1 && cards1[cs1].equals(want)){
                cs1+=1;
                continue;
            }
            
            if(cs2 < len2 && cards2[cs2].equals(want)){
                cs2+=1;
                continue;
            }
            
            isPossi = true;
            break;
        }
        
        return isPossi?"No":"Yes";
    }
}