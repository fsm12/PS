import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String s = conversionN(n, k);

        String[] sArray = s.split("0");

        for(int i = 0; i < sArray.length; i++){
            if(sArray[i].equals("")) continue;
            if(isSosu(sArray[i])) answer++;
        }
        return answer;
    }

    public String conversionN(int n, int k){
        StringBuilder sb = new StringBuilder();
        int current = n;

        while(current > 0){
            sb.append(current%k);
            current /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isSosu(String s){
        long n = Long.parseLong(s);

        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}