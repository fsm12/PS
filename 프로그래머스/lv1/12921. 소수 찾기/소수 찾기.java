class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n+1];
        int ans = n-1;
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    ans -= isNotPrime[j] ? 0 : 1;
                    isNotPrime[j] = true;
                }
            }
        }
        return ans;
    }
}