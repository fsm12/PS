import java.util.*;

class Solution {
    static int total=0, div=0;
    
    public int solution(String str1, String str2) {
		Map<String, Integer> map1 = getMap(str1.toUpperCase());
		Map<String, Integer> map2 = getMap(str2.toUpperCase());

		for (String s : map1.keySet()) {
			if (map2.containsKey(s))
				div += Math.min(map1.get(s), map2.get(s));
		}
		total -= div;

		return (int)((total==0 ? 1 : (double)div/(double)total) * 65536);
	}

	private static Map<String, Integer> getMap(String s) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length() - 1; i++) {
            String tmp = s.substring(i, i+2);
			if (isAlpha(tmp)) {
                total+=1;
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
			}
		}
		return map;
	}
    
    public static boolean isAlpha(String s) {
        return s != null && s.matches("^[a-zA-Z]*$");
    }
}