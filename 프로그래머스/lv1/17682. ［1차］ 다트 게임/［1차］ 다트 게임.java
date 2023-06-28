import java.util.regex.*;

class Solution {
    public int solution(String dartResult) {
        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);
        
        int[] score = new int[3];
        int idx = 0;
        while(matcher.find()){
            score[idx] = Integer.parseInt(matcher.group(1));
            
            if(matcher.group(2).charAt(0) == 'D'){
                score[idx] = (int) Math.pow(score[idx], 2);
            }
            
            if(matcher.group(2).charAt(0) == 'T'){
                score[idx] = (int) Math.pow(score[idx], 3);
            }
            
            idx++;
            
            if(!matcher.group(3).isEmpty()){
                if(matcher.group(3).charAt(0) == '*'){
                    score[idx-1]*=2;
                    if(2<=idx){
                        score[idx-2]*=2;
                    }
                }

                if(matcher.group(3).charAt(0) == '#'){
                    score[idx-1]*=-1;
                }
            }
        }
        
        
        int ans = 0;
        for(int i=0; i<3; i++){
            ans += score[i];
        }
        return ans;
    }
}