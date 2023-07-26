class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int N = s.length(), p=0;
        char[] stack = new char[N];
        
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(p!=0 && stack[p-1] == '('){
                    p-=1;
                    continue;
                }else{
                    answer = false;
                    break;
                }
            }
            stack[p++] = c;
        }
        return p==0 && answer?true:false;
    }
}