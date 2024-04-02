class Solution {
    public String solution(String s, String skip, int index) {
        String abc = "abcdefghijklmnopqrstuvwxyz";
        for(char c : skip.toCharArray()){
            abc = abc.replaceAll(c+"","");
        }
        
        int N = abc.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            
            int idx = 0;
            for(int n=0; n<N; n++){
                if(s.charAt(i) == abc.charAt(n)){
                    idx = n;
                    break;
                }
            }
            
            sb.append(abc.charAt((idx+index)%N));
        }
        return sb.toString();
    }
}