class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        int point = 0;
        for(int idx=food.length-1; idx>0; idx--){
            for(int i=0; i<food[idx]/2; i++){
                sb.insert(0, idx);
                sb.append(idx);
                point++;
            }
        }
        return sb.toString();
    }
}