import java.util.*;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            int val = Integer.parseInt(st.nextToken());
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        
        return sb.toString();
    }
}