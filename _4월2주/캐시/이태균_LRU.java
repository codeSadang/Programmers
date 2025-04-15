package _4월2주.캐시;

import java.util.LinkedHashMap;
import java.util.Map;

public class 이태균_LRU {

    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int result = solution(cacheSize, cities);

        System.out.println(result);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Lru lru = new Lru(cacheSize);
        for (String city : cities) {
            city = city.toLowerCase();
            boolean isHit = lru.refer(city);
            answer += isHit ? 1 : 5;
        }

        return answer;
    }

    static class Lru {
        private final int capacity;
        private final Map<String, String> cache;

        public Lru(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
                protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                    return size() > Lru.this.capacity;
                }
            };
        }

        private boolean refer(String key) {
            boolean isHit = cache.containsKey(key);
            cache.put(key, key);
            return isHit;
        }
    }

}