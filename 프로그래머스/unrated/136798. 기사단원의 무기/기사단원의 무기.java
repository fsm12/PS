class Solution {
    public int solution(int number, int limit, int power) {
        int[] cnt = new int[number + 1];    
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number/i; j++) {
                cnt[i*j]++;
            }
        }
        int ans = 0;
        for (int i = 1; i <= number; i++) {
            if (limit < cnt[i]) {
                ans += power;
            } else {
                ans += cnt[i];
            }
        }
        return ans;
    }
}