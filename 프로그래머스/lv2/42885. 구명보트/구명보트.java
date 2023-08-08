import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int N = people.length;
        Arrays.sort(people);
        
        int s=0, e=N-1, save=0;
        while(s<e){
            if(limit < people[s]+people[e]){
                e-=1;
            }else{
                s+=1;
                e-=1;
                save+=1;
            }
        }
        return N-save;
    }
} 