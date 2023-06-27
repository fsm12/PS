import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        int max_depart = 0;
        int[] cnt = new int[N+2];
        for(int stage : stages){
            cnt[stage]++;
            max_depart = Math.max(max_depart, stage);
        }
        
        int total = stages.length;
        for(int n=1; n<N+1; n++){
            if(cnt[n]==total && max_depart < n){
                map.put(n, 0.0);
            }else{
                map.put(n, (double)cnt[n]/total);
            }
            total -= cnt[n];
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1,o2) -> Double.compare(map.get(o2), map.get(o1)));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}