import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int score_len = score.length;
        int[] answer = new int[score_len];
        int ans_idx = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(score_len < k){
            k = score_len;
        }
        
        for(int i=0; i<k; i++){
            pq.add(score[i]);
            answer[ans_idx++] = pq.peek();
        }
        
        for(int i=k; i<score_len; i++){
            if(pq.peek() < score[i]){
               pq.poll();
               pq.add(score[i]);
            } 
            answer[ans_idx++] = pq.peek();
        }
        return answer;
    }
}