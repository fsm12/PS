import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] ans = Arrays.stream(arr).filter(f -> f%divisor == 0).toArray();
        Arrays.sort(ans);
        return ans.length == 0?new int[]{-1}:ans;
    }
}