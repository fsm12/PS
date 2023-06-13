class Solution {
    public String solution(int[] food) {
        int size = 1;
        for(int i=1; i<food.length; i++){
            food[i] /= 2; 
            size += food[i];
        }
        size *= 2;
        
        char[] answer = new char[size-1];
        int point = 0;
        for(int idx=1; idx<food.length; idx++){
            for(int i=0; i<food[idx]; i++){
                answer[point] = Integer.toString(idx).charAt(0);
                answer[size-point-2] = Integer.toString(idx).charAt(0);
                point++;
            }
        }
        answer[point] = '0';
        return String.valueOf(answer);
    }
}