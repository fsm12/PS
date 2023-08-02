class Solution{
    public int solution(String s){
        int N = s.length(), p = 0;
        int[] stack = new int[N];
        
        for(char c : s.toCharArray()){
            if(0<p && stack[p-1] == c){
                p-=1;
                continue;
            }
            stack[p++] = c;
        }
        return p==0?1:0;
    }
}