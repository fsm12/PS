import java.util.*;
/*
skip에 속하는 문자는 건너뛰고 s각각을 index만큼의 다음 문자로 치환하는 문제

[s의 문자 < skip 문자 < s의 문자 + index값] 에 해당하는 skip 문자가 있다면 그 개수만큼 +1하고 (개수-a)%z로 치환


*/

class Solution {
    public String solution(String inp_s, String inp_skip, int inp_index) {
        String answer = "";
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
            answer += s;
        }
        
        
        return answer;
    }
}