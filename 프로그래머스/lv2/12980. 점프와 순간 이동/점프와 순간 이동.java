import java.util.*;

public class Solution {
    public int solution(int N) {
        int ans = 0;
        double n = N;
        while(n!=0){
            n/=2;
            if((int)n == n)
                continue;
            ans+=1;
            n = (int)n;
        }
        return ans;
    }
}