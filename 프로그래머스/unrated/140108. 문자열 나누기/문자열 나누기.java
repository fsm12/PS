class Solution {
    public int solution(String s) {
        int split_cnt = 1;
        
        char standard = s.charAt(0);
        int std_cnt = 1, other_cnt = 0;
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            if(standard == c){
                std_cnt++;
            }else{
                other_cnt++;
            }
            
            if(std_cnt == other_cnt){
                i++;
                if(s.length() <= i)
                    break;
                standard = s.charAt(i);
                split_cnt++;
                
                std_cnt = 1;
                other_cnt = 0;
            }
        }
        
        return split_cnt;
    }
}