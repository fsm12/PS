class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long p_long = Long.parseLong(p);
        StringBuilder sb_t = new StringBuilder(t);
        for(int i=pLen; i<=t.length(); i++){
            if(Long.parseLong(sb_t.substring(i-pLen,i)) <= p_long){
                answer+=1;
            }
        }
        return answer;
    }
}