import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int node : numbers){
             pq.add(node);
         }
        
        int cnt = 0, num_size = numbers.length, possi_size = pq.poll()+pq.poll()+1;
        boolean[] possi_nums = new boolean[possi_size];
        
        for(int i=0; i<num_size; i++){
            for(int j=i+1; j<num_size; j++){
                if(possi_nums[numbers[i]+numbers[j]])
                    continue;
                possi_nums[numbers[i]+numbers[j]] = true;
                cnt += 1;
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<possi_size; i++){
            if(possi_nums[i]){
                answer[idx] = i;
                idx+=1;
            }
        }
        return answer;
    }
}