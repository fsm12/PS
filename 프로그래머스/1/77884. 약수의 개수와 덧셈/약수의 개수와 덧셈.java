/*
약수의 개수가 홀수 -> 제곱이 있다?

1 -> 1 == 1^2 (홀수)
2 -> 1,2 
3 -> 1,3
25 -> 1 5 25 == 5^2 (홀수)

=> 제곱이 몇개냐를 찾는 문제
*/

import java.util.*;

class Solution {
    int[] dp;
    
    public int solution(int left, int right) {
        
        dp = new int[right+1];
        dp[0] = 0;
        for(int i=1; i<=right; i++){
            dp[i] = dp[i-1] + i;
        }
        
        int leftSqrt = (int)Math.sqrt(left);
        int rightSqrt = (int)Math.sqrt(right);
        
        int ans = dp[right]-dp[left-1];
        for(int i=leftSqrt; i<=rightSqrt; i++){
            if(Math.pow(i,2) < left)
                continue;
            ans -= 2*Math.pow(i,2);
        }
        return ans;
    }
}