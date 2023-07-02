class Solution {
    public int solution(String[] babbling) {
        int ans = 0;
        for (String s : babbling) {
            s = s.replaceAll("ayaaya|yeye|woowoo|mama", ".");
            s = s.replaceAll("aya|ye|woo|ma", "");
            if (s.equals(""))
                ans++;
        }
        return ans;
    }
}