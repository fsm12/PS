class Solution {
    public int[] solution(String[] wallpaper) {
        int xMin = Integer.MAX_VALUE, yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE, yMax = Integer.MIN_VALUE;
        
        int N = wallpaper.length, M = wallpaper[0].length();
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(wallpaper[n].charAt(m) == '#'){
                    xMin = Math.min(xMin, n);
                    yMin = Math.min(yMin, m);
                    xMax = Math.max(xMax, n+1);
                    yMax = Math.max(yMax, m+1);
                }
            }
        }
        return new int[]{xMin, yMin, xMax, yMax};
    }
}