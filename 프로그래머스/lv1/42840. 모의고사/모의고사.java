import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] man1 = {1,2,3,4,5};
        int[] man2 = {2,1,2,3,2,4,2,5};
        int[] man3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i] == man1[i%5])  
                cnt[0]++;
            if(answers[i] == man2[i%8])  
                cnt[1]++;
            if(answers[i] == man3[i%10]) 
                cnt[2]++;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int max = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        if(max == cnt[0])
            list.add(1);
        if(max == cnt[1])
            list.add(2);
        if(max == cnt[2])
            list.add(3);
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}