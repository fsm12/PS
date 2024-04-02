class Solution {
    public int[] solution(long n) {
        int len = String.valueOf(n).length();
        
        int[] ans = new int[len];
        for(int i=0; i<len; i++){
            ans[i] = (int) (n%10);
            n/=10;
        }
        return ans;
    }
}