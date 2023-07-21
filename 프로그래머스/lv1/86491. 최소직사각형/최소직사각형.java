class Solution {
    public int solution(int[][] sizes) {
        int mx=0, my=0;
        
        for(int[] size : sizes){
            int sx = 0, sy = 0;
            if(size[0] < size[1]){
                sx = size[1];
                sy = size[0];
            }else{
                sx = size[0];
                sy = size[1];
            }
            mx = Math.max(mx, sx);
            my = Math.max(my, sy);
        }
        return mx*my;
    }
}