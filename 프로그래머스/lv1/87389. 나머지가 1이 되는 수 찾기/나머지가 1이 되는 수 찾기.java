class Solution {
    public int solution(int n) {
        int ans = n-1;
        for(int i=2; i<n-2; i++){
            if(ans%i==0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}