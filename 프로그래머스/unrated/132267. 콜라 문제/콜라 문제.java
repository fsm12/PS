class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;
        int empty = n;
        
        while(empty >= a) {
            int get = empty / a * b ;
            
            empty = empty % a + get;
            ans += get;
        }
        return ans;
    }
}