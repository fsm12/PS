class Solution {
    public int solution(int[] numbers) {
        boolean[] isExist = new boolean[10];
        for(int num : numbers){
            isExist[num] = true;
        }
        
        int ans = 0;
        for(int i=0; i<10; i++){
            if(!isExist[i])
                ans += i;
        }
        return ans;
    }
}