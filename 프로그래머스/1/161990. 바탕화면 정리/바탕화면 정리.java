class Solution {
    public int[] solution(String[] wallpaper) {
        int[] ans = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    ans[0] = Math.min(ans[0], i);
                    ans[1] = Math.min(ans[1], j);
                    ans[2] = Math.max(ans[2], i+1);
                    ans[3] = Math.max(ans[3], j+1);
                }
            }
        }
        return ans;
    }
}