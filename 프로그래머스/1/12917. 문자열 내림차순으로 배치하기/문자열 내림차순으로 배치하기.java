import java.util.*;

class Solution {
    public String solution(String s) {
        char[] cArr = s.toCharArray();
        Arrays.sort(cArr);
        
        // System.out.println(cArr);
        StringBuilder sb = new StringBuilder();
        for(int i=cArr.length-1; 0<=i; i--){
            sb.append(cArr[i]);
        }
        return sb.toString();
    }
}