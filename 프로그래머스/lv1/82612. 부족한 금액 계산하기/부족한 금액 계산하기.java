class Solution {
    public long solution(int price, int money, int count) {
        long ans = 0;
        for(int i=1; i<=count; i++){
            ans+=price*i;
        }
        return money<ans?ans-money:0;
    }
}