import java.util.*;

class Solution{
    public int solution(int n, int a, int b){
        int round = 1;
        while(true){
            a = (int)Math.ceil(a/2.0);
            b = (int)Math.ceil(b/2.0);
            if(a==b)
                break;
            round++;
        }
        return round;
    }
}