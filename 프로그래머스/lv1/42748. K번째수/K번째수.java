import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int point = 0;
        for(int[] com : commands){
            int i = com[0], j= com[1], k = com[2];
            int[] get_arr = new int[j-i+1];
            for(int idx=i-1; idx<j; idx++){
                get_arr[idx-i+1] = array[idx];
            }
            Arrays.sort(get_arr);
            answer[point++] = get_arr[k-1];
        }
        return answer;
    }
}