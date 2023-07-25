import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append(" ");
                first = true;
                continue;
            }
            
            if(first){
                if('a'<=c)
                   c -= 'a'-'A';
                sb.append(c);
                first = false;
                continue;
            }
            
            if(c<'a')
                c += 'a'-'A';
            sb.append(c);
        }
        return sb.toString();
    }
}