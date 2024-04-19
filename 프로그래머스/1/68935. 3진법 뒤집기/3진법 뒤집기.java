class Solution {
    static int[] stack;
    static int p;
    
    public int solution(int n) {
        p=0;
        stack = new int[n+1];
        while(3<=n){
            stack[p++] = n%3;
            n/=3;
        }
        stack[p] = n;
        
        int ans = 0;
        for(int i=0; i<=p; i++){
            ans += (int)Math.pow(3, p-i) * stack[i];
        }
        return ans;
    }
}