package _4월1주.롤케이크자르기;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제
 *  롤케이크를 두 조각으로 자르려고 한다.
 *  철수와 철수 동생은 롤케이크를 공평하게 나눠먹으려고 한다.
 *  철수와 동생에게 공평은 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각한다.
 *  토핑은 일렬로 올라가 있다.
 *
 * 2. 문제분석
 *  문제를 처음 봤을때, 일렬로 올라가 있는 토핑의 가짓수가 동일하게 자른다에서, 슬라이딩 윈도우 + HashMap 을 이용한 풀이로 생각함.
 *  토핑의 개수와 상관없이, 토핑의 종류가 동일하게 나누어지는 경우(Map에 존재하는 Key 값이 전체 토핑의 개수의 절반과 동일한 경우)
 *
 *  3. 문제풀이
 *  Map 2개를 활용하여 풀이
 *
 * */
public class 홍창모 {
    public static void main(String[] args) {
        int[] topping = {1,2,1,3,1,4,1,2};
        //int[] topping = {1,2,3,1,4};

        int answer = solution(topping);

        System.out.print(answer);
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for( int i = 0; i < topping.length; i++ ) {
            map2.put( topping[i], map2.getOrDefault( topping[i], 0 ) + 1 );
        }

        for( int i = 0; i < topping.length; i++ ) {
            map1.put( topping[i], map1.getOrDefault( topping[i], 0 ) + 1 );

            if( map2.get(topping[i]) - 1 == 0 ) {
                map2.remove(topping[i]);
            } else {
                map2.put( topping[i], map2.get(topping[i]) - 1 );
            }

            if( map1.size() == map2.size() ) answer++;
        }

        return answer;
    }
}
