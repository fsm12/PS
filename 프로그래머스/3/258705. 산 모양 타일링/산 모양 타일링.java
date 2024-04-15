import java.util.*;

class Solution {
    static int len;
    static final int divide = 10007;
    static long[] dp, dp_final;
    
    public int solution(int N, int[] tops) {
        int ans = 0;
        
        len = 2*N+1;
        dp = new long[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=len; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        dp_final = new long[len+1];
        dp_final[0] = 1;
        dp_final[1] = 1;
        for(int i=2; i<=len; i++){
             if(i%2==0){
                 switch(tops[i/2-1]){
                    case 0:
                         dp_final[i] = (dp_final[i-1] + dp_final[i-2]) % divide;
                        break;
                    case 1:
                        dp_final[i] = (dp_final[i-1] + dp_final[i-1] + dp_final[i-2]) % divide;
                        break;
                 }
                 continue;
             }
             dp_final[i] = (dp_final[i-1] + dp_final[i-2]) % divide;
        }
        
        
        return (int)(dp_final[len]%divide);
    }
}