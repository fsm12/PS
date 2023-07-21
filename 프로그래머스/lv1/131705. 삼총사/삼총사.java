class Solution {
    public int solution(int[] number) {
        return nCr(-1,0,0,number);
    }
    
    public static int nCr(int start, int depth, int sum, int[] number){
        if(depth==3){
            if(sum == 0)
                return 1;
            return 0;
        }
        
        int ans = 0;
        for(int i=start+1; i<number.length; i++){
            ans += nCr(i, depth+1, sum+number[i], number);
        }
        return ans;
    }
}