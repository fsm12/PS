import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans_idx = 0, pq_size = 0;
        for(int sc : score){
            pq.add(sc);
            pq_size += 1;
            if(pq_size > k){
                pq.poll();
                pq_size -= 1;
            }
            answer[ans_idx++] = pq.peek();
        }
        return answer;
    }
}