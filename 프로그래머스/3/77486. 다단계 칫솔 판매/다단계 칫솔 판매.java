/*

enroll ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	
referral ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	
seller ["young", "john", "tod", "emily", "mary"]	
amount [12, 4, 2, 5, 10]	

result [360, 958, 108, 0, 450, 18, 180, 1080]

위 / 방향성
*/

import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static Map<String, Integer> nameIdxMap;
    static int[] ans;
    
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        nameIdxMap = new HashMap<>();
        
        int N = 0;
        for(String name : enroll){
            nameIdxMap.put(name, N++);
        }
        
        adjList = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            adjList[i] = new ArrayList<>();
        }
        
        
        int i=0;
        for(String ref : referral){
            if(ref.equals("-")){
                i++;
                continue;
            }
            int nameIdx = nameIdxMap.get(enroll[i++]);
            int refIdx = nameIdxMap.get(ref);
            adjList[nameIdx].add(refIdx);
        }
        
        i=0;
        ans = new int[N];
        for(String sell : seller){
            int nameIdx = nameIdxMap.get(sell);
            int money = amount[i++]*100;
            moneyDistribution(nameIdx, money);
        }
        
        return ans;
    }
    
    public static void moneyDistribution(int idx, int money){
        int upMoney = money/10;
        ans[idx] += money - upMoney;
        
        if(adjList[idx].size()==0){
            //ans[idx] += upMoney;
            return;
        }
        moneyDistribution(adjList[idx].get(0), upMoney);
    }
}