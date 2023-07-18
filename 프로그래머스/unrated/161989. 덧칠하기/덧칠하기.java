
class Solution {
    public int solution(int n, int m, int[] section) {
        int ans = 0, max = 0;
        for (int sec : section) {
            if (max <= sec) {
                max = sec + m;
                ans++;
            }
        }
        return ans;
    }
}