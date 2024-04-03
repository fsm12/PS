import java.util.*;

class Solution {
    static int maxNum, minNum;
    
    public int[] solution(String[] operations) {
        int[] ans = {};
        
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String op : operations){
            StringTokenizer st = new StringTokenizer(op);
            String alpha = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(alpha.equals("I")){
                pqMin.add(num);
                pqMax.add(num);
                map.put(num, map.getOrDefault(num, 0)+1);
                continue;
            }
            
            if(num==1){
                maxNum = 0;
                while(true){
                    if(pqMax.size()==0)
                        break;
                    maxNum = pqMax.poll();
                    Integer cnt = map.getOrDefault(maxNum,0);
                    if(cnt == 0)  continue;
                    if(cnt == 1) map.remove(maxNum);
                    if(1 < cnt) map.put(maxNum, cnt-1);
                    break;
                }
                
            }else if(num==-1){
                minNum = 0;
                while(true){
                    if(pqMin.size()==0)
                        break;
                    minNum = pqMin.poll();
                    Integer cnt = map.getOrDefault(minNum, 0);
                    if(cnt == 0) continue;
                    if(cnt == 1) map.remove(minNum);
                    if(1 < cnt) map.put(minNum, cnt-1);
                    break;
                }
            }
        }
        
        if(map.size()==0){
            ans = new int[]{0,0};
        }else{
            maxNum = 0;
            while(true){
                if(pqMax.size()==0)
                    break;
                maxNum = pqMax.poll();
                Integer cnt = map.getOrDefault(maxNum, 0);
                if(cnt == 0)  continue;
                if(cnt == 1) map.remove(maxNum);
                if(1 < cnt) map.put(maxNum, cnt-1);
                break;
            }
            
            minNum = 0;
            while(true){
                if(pqMin.size()==0)
                        break;
                minNum = pqMin.poll();
                Integer cnt = map.getOrDefault(minNum,0);
                if(cnt == 0) continue;
                if(cnt == 1) map.remove(minNum);
                if(1 < cnt) map.put(minNum, cnt-1);
                break;
            }
            ans = new int[]{maxNum, minNum};
        }
        
        return ans;
    }
}