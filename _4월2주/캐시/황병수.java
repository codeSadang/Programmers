package _4월2주.캐시;

import java.util.ArrayDeque;

public class 황병수 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int time = 0;

        // 예외케이스
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        ArrayDeque<String> cache = new ArrayDeque<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) { // cache hit
                cache.remove(city);
                time += 1;
            } else { // cache miss
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                time += 5;
            }
            cache.offer(city);
        }
        return time;
    }
}
