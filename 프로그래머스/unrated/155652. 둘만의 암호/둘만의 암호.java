import java.util.*;

class Solution {
    
    public String solution(String inp_s, String inp_skip, int inp_index) {
        StringBuilder answer = new StringBuilder();
        for(char s : inp_s.toCharArray()){
             for (int index = 0; index < inp_index; index++) {
                s += 1;
                if (s > 'z') {
                    s -= 26;
                }
                if (inp_skip.contains(String.valueOf(s))) {
                    index--;
                }
            }
            answer.append(s);
        }
        return answer.toString();
    }
}