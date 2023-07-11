class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int p = 0, ans = 0;
        for (int i : ingredient) {
            stack[p++] = i;
            if (3 < p && stack[p - 1] == 1 && stack[p - 2] == 3 && stack[p - 3] == 2 && stack[p - 4] == 1) {
                p -= 4;
                ans++;
            }
        }
        return ans;
    }
}