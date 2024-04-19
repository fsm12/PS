class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int ans = 0, i=0;
        for(boolean isPlus : signs){
            ans += isPlus?absolutes[i]:-absolutes[i];
           i++;
        }
        return ans;
    }
}