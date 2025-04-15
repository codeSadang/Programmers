package _4월2주.캐시;

import java.util.ArrayDeque;
import java.util.Deque;

public class 이태균 {

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

        Deque<String> deque = new ArrayDeque<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (deque.contains(city)) {
                deque.remove(city);
                answer += 1;
            } else {
                if (deque.size() == cacheSize) {
                    deque.poll();
                }
                answer += 5;
            }

            deque.offer(city);
        }

        return answer;
    }

}