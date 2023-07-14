import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int N = id_list.length;
        Map<String, Integer> order = new HashMap<>();
        for(int n=0; n<N; n++){
            order.put(id_list[n], n);
        }
        
        Map<String, Set<String>> report_res = new LinkedHashMap<>();
        int[] cnt = new int[N];
        
        for(String rep : report){
            StringTokenizer st = new StringTokenizer(rep);
            String user_a = st.nextToken();
            String user_b = st.nextToken();
            
            if(report_res.containsKey(user_a)){
                if(report_res.get(user_a).contains(user_b))
                    continue;
                report_res.get(user_a).add(user_b);
            }else{
                Set<String> set = new LinkedHashSet<>();
                set.add(user_b);
                report_res.put(user_a, set);
            }
            cnt[order.get(user_b)] += 1;
        }
        
        int[] ans = new int[N];
        int point = 0;
        for(String id : id_list){
            for(String val : report_res.getOrDefault(id, new HashSet<>())){
                int idx = order.get(val);
                if(k <= cnt[idx]){
                    ans[point]+=1;
                }
            }
            point+=1;
        }
        
        return ans;
    }
}