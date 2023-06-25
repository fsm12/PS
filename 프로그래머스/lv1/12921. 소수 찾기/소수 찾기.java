class Solution {
    public int solution(int n) {
        boolean[] isNotPrime = new boolean[n+1];
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<=n; j+=i){
                    isNotPrime[j] = true;
                }
            }
        }
        
        int ans = 0;
        for(int i=2; i<=n; i++){
            ans += isNotPrime[i]?0:1;
        }
        return ans;
    }
}