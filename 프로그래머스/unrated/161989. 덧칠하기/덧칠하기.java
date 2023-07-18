class Solution {
    public int solution(int N, int M, int[] section) {
        int ans = 0, secLen = section.length, i=0;
        for(int n=1; n<=N; n++){
            if(i<secLen){
                if(n == section[i]){
                    ans++;
                    n+=M-1;
                    while(i<secLen && section[i] <= n){
                        i++;
                    }
                }
            }else
                break;
        }
        return ans;
    }
}