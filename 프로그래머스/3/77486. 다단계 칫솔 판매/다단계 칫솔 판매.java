import java.util.*;

class Solution {
    static List<Integer>[] adjList;
    static Map<String, Integer> nameIdxMap;
    static int[] ans;
    static int i=0;
    
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
        
        i=0;
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
            moneyDistri(nameIdx, money);
        }
        return ans;
    }
    
    public static void moneyDistri(int idx, int money){
        int upMoney = money/10;
        ans[idx] += money - upMoney;
        
        if(adjList[idx].size()==0) 
            return;
        
        moneyDistri(adjList[idx].get(0), upMoney);
    }
}