import java.util.*;

class Solution {
    public String solution(String inp_s, String inp_skip, int inp_index) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(String skip : inp_skip.split("")){
            alpha = alpha.replace(skip, "");
        }
        
        int len = alpha.length();
        StringBuilder ans = new StringBuilder();
        for(String s : inp_s.split("")){
            ans.append(alpha.charAt((alpha.indexOf(s) + inp_index)%len));
        }
        return ans.toString();
    }
}