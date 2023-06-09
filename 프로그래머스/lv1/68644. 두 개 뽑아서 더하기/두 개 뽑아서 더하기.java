import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int node : numbers){
             pq.add(node);
         }
        
        int cnt = 0;
        int[] possi_nums = new int[pq.poll()+pq.poll()+1];
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(possi_nums[numbers[i]+numbers[j]] == 1)
                    continue;
                possi_nums[numbers[i]+numbers[j]] = 1;
                cnt += 1;
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<possi_nums.length; i++){
            if(possi_nums[i] == 1){
                answer[idx] = i;
                idx+=1;
            }
        }
        return answer;
    }
}