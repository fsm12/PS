// 빈 a병을 가져다주면 새 b병을 얻음
class Solution {
    public int solution(int a, int b, int n) {
        int empty = n, ans = 0;
        while(empty >= a){
            empty-=a;
            empty+=b;
            ans += b;
        }
        return ans;
    }
}