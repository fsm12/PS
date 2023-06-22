class Solution {
    public int solution(int k, int m, int[] score) {
        int[] apple_cnt = new int[k+1];
        for(int sc : score){
            apple_cnt[sc]+=1;
        }
        
        int ans = 0, cnt = 0, idx=k;
        while(true){
            if(idx==0)
                break;
            cnt += apple_cnt[idx];
            if(cnt < m){
                idx--;
                continue;
            }
            ans += idx * m * (cnt/m);
            cnt %= m;
            idx--;
        }
        return ans;
    }
}