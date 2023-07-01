import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] numX = new int[10];
        for(int i=0; i<X.length(); i++) {
            numX[X.charAt(i)-'0']++;
        }
        
        int[] numY = new int[10];
        for(int i=0; i<Y.length(); i++) {
            numY[Y.charAt(i)-'0']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i=9; i>=0; i--) {
            if(numY[i]>0 && numX[i]>0) {
                answer.append(i);
                numY[i]--;
                numX[i]--;
                i++;
            }
        }
        
        String ans = answer.toString();
        if("".equals(ans))
           return "-1";
        else if(ans.charAt(0)=='0')
           return "0";
        else
            return ans;
    }
}