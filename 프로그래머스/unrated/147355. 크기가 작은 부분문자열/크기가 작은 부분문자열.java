class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLen = p.length();
        long p_long = Long.parseLong(p);
        for(int i=0; i<t.length()-pLen+1; i++){
            if(Long.parseLong(t.substring(i,i+pLen)) <= p_long){
                answer+=1;
            }
        }
        return answer;
    }
}