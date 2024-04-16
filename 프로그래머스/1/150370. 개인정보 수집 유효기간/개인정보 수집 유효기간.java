import java.util.*;

class Solution {
    static StringTokenizer st;
    
    public int[] solution(String inp_today, String[] inp_terms, String[] inp_privacies) {
        Map <Character, Integer> map = new HashMap<>();
        
        for (String terms : inp_terms) {
            st = new StringTokenizer(terms);
            map.put(st.nextToken().charAt(0), Integer.parseInt(st.nextToken())*28);
        }
        
        st = new StringTokenizer(inp_today, ".");
        int ty = Integer.parseInt(st.nextToken());
        int tm = Integer.parseInt(st.nextToken());
        int td = Integer.parseInt(st.nextToken());
        
        List<Integer> ans_list = new ArrayList<>();
        for (int p=0; p < inp_privacies.length; p++) {
            st = new StringTokenizer(inp_privacies[p], " ");
            String pastDate = st.nextToken();
            char c = st.nextToken().charAt(0);
            
            int valid_gap = map.get(c);
            
            st = new StringTokenizer(pastDate, ".");
            int tp_gap = (ty - Integer.parseInt(st.nextToken()))*28*12
                + (tm - Integer.parseInt(st.nextToken()))*28
                + (td - Integer.parseInt(st.nextToken()));

            if (tp_gap >= valid_gap) {
                ans_list.add(p+1);
            }
        }
        return ans_list.stream().mapToInt(i -> i).toArray();
    }
}