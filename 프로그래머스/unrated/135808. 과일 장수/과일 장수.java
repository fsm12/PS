class Solution {
    public int solution(int k, int m, int[] score) {
        int[] apple = new int[k+1];
        for(int sc : score){
            apple[sc]+=1;
        }
        
        int ans = 0, cnt = 0;
        for(int idx = k; idx>0; idx--){
            cnt += apple[idx];
            if(cnt < m){
                continue;
            }
            ans += idx * m * (cnt/m);
            cnt %= m;
        }
        return ans;
    }
}