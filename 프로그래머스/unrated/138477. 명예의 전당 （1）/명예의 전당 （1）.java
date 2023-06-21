import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int score_len = score.length;
        int[] answer = new int[score_len];
        int ans_idx = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<score_len; i++){
            pq.add(score[i]);
            if(pq.size() > k){
                pq.poll();
            }
            answer[ans_idx++] = pq.peek();
        }
        return answer;
    }
}