class Solution {
    public int solution(int[] nums) {
        boolean[] isNotPrime = new boolean[3000];
        for(int i=2; i<3000; i++){
            for(int j=2; i*j<3000; j++){
                isNotPrime[i*j] = true;
            }
        }
        return nCr(-1,0,0,nums,isNotPrime);
    }
    
    public int nCr(int start, int cnt, int sum, int[] nums, boolean[] isNotPrime){
        if(cnt == 3){
            if(!isNotPrime[sum]){
                return 1;
            }
            return 0;
        }
        
        int cur_ans = 0;
        for(int i=start+1; i<nums.length; i++){
            cur_ans += nCr(i, cnt+1, sum+nums[i], nums, isNotPrime);
        }
        return cur_ans;
    }
}