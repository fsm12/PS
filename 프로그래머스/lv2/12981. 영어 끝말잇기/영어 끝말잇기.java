import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        char c = '_';
        int N = words.length;
        int i = 0;
        boolean flag = true;
        Set<String> set = new HashSet<>();
        for(String word : words){
            if((c=='_' || c==word.charAt(0)) && !set.contains(word)){
                c = word.charAt(word.length()-1);
                i++;
                set.add(word);
                continue;
            }
            flag = false;
            break;
        }
        System.out.println(i);
        return flag?new int[]{0,0}:new int[]{(i+1)%n==0?n:(i+1)%n, (int)Math.ceil((double)(i+1)/n)};
    }
}