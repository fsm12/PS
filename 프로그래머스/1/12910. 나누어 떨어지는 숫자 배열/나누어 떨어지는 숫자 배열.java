import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        int idx = 0;
        for(int num : arr){
            if(arr[idx]%divisor == 0){
                list.add(arr[idx]);
            }
            idx++;
        }
        
        int[] ans;
        idx = 0;
        if(list.size() == 0){
            ans = new int[]{-1};
        }else{
            ans = new int[list.size()];
            for(int val : list){
                ans[idx++] = val;
            }
            Arrays.sort(ans);
        }
        
        return ans;
    }
}