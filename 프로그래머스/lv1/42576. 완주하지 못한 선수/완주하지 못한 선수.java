import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String parti : participant) {
            map.put(parti, map.getOrDefault(parti, 0) + 1);
        }

        for (String com : completion) {
            Integer cnt = map.get(com);
            if (cnt != null && cnt == 1) {
                map.remove(com);
            } else {
                map.put(com, cnt - 1);
            }
        }

        return map.keySet().iterator().next();
    }
}