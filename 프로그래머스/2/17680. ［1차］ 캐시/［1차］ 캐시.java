import java.util.ArrayList;
import java.util.List;

public class Solution {

    static final int HIT = 1;
    static final int MISS = 5;

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            // 캐시 사이즈가 없는 경우 예외
            return cities.length * MISS;
        }
        

        for (String city : cities) {
            // System.out.println(cache);
            // 대소문자 통일
            city = city.toLowerCase();

            if (cache.size() < cacheSize) {
                // 캐시 사이즈보다 작은 경우

                if (cache.contains(city)) {
                    // 캐시 사이즈보다 작지만, 캐시에 속한 경우
                    answer += HIT;
                } else {
                    // 캐시 사이즈보다 작지만, 캐시에 없는 경우
                    answer += MISS;
                }
                    cache.add(city);
                continue;
            }

            // 캐시 사이즈보다 큰 경우
            if (cache.contains(city)) {
                // 캐시 사이즈보다 크면서 캐시 안에 존재하는 경우
                cache.remove(city);
                cache.add(city);
                answer += HIT;
            } else {
                // 캐시 사이즈보다 크지만, 캐시 안에 도시가 존재하지 않는 경우
                cache.remove(0);
                cache.add(city);
                answer += MISS;
            }
        }

        return answer;
    }
}