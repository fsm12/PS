class Solution {
    static long[] dp;
    
    public long solution(int N) {
        dp = new long[N+2];
        dp[1]=1;
        dp[2]=2;
        
        for(int n=3; n<=N; n++){
            dp[n] = (dp[n-2] + dp[n-1])%1234567;
        }
        return dp[N];
    }
}