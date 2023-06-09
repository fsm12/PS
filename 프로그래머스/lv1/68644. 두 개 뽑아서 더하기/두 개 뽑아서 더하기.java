import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> possi_nums = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                possi_nums.add(numbers[i]+numbers[j]);
            }
        }
        
        int[] answer = possi_nums.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}