class Solution {
    public int solution(int[] bandage, int maxHealth, int[][] attacks) {
        int t = bandage[0], x = bandage[1], y = bandage[2];
        
        int curHealth = maxHealth, idx = 1;
        for(int[] attack : attacks){
            int attackTime = attack[0];
            int attackAmount = attack[1];
            
            int conti = 0;
            for(int i=idx; i<attackTime; i++){
                conti++;
                curHealth = Math.min(maxHealth, curHealth + x);
            }
            if(t <= conti){
                curHealth = Math.min(maxHealth, curHealth + y * (conti/t));
            }
        
            idx = attackTime+1;
            curHealth -= attackAmount;
            
            if(curHealth <= 0)
                return -1;
        }
        return curHealth;
    }
}