class Solution {
    public int solution(int[] ingred) {
        int[] stack = new int[ingred.length+1];
        
        int p=0, ans=0;
        for(int next : ingred){
            if(3 <= p && next == 1){
                if(stack[p-1]==3 && stack[p-2]==2 && stack[p-3]==1) {
                    ans++;
                    p-=3;
                    continue;
                }
            }
            stack[p++] = next;
        }
        return ans;
    }
}