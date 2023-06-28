class Solution {
    public int solution(String dartResult) {
        int[] score = new int[3];
        
        int idx = 0;
        for(char c : dartResult.toCharArray()){
            if(Character.isDigit(c)){
                score[idx] = score[idx]*10 + (c - '0');
                // System.out.println(score[idx]);
                continue;
            }
            
            if(c == '*'){
                score[idx-1]*=2;
                if(2<=idx){
                    score[idx-2]*=2;
                }
                continue;
            }
            
            if(c == '#'){
                score[idx-1]*=-1;
                continue;
            }
            
            if(c == 'D'){
                score[idx] = (int) Math.pow(score[idx], 2);
            }
            
            if(c == 'T'){
                score[idx] = (int) Math.pow(score[idx], 3);
            }
            
            idx++;
        }
        int ans = 0;
        for(int i=0; i<3; i++){
            ans += score[i];
        }
        return ans;
    }
}