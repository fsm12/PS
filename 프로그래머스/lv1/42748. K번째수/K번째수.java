// (5-2+1)-3+1 = j-i-k+2 => pq.poll()할 횟수

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int point = 0;
        for(int[] command : commands){
            int i = command[0], j= command[1], k = command[2];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int idx=i-1; idx<j; idx++){
                pq.add(array[idx]);
            }
            int ans = 0;
            for(int idx = 0; idx<j-i-k+2; idx++){
                ans = pq.poll();
            }
            answer[point++] = ans;
        }
        return answer;
    }
}