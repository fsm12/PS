class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(true){
            int x=0;
            answer[0]++;
            for(char c : s.toCharArray()){
                if(c=='1'){
                    x++;
                    continue;
                }
                answer[1]++;
            }
            
            if(x==1)
                break;
            
            s = Integer.toString(x,2);
        }
        return answer;
    }
}