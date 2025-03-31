package _3월4주.할인행사;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 문제분석
 * XZY 마트는 일정한 금액을 지불하면 10일동안 회원 자격을 부여한다.
 * 알뜰한 정현이는 자신이 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입을 하려한다.
 * 정현이가 원하는 제품을 나타내는 문자열 배열 want와 정현이가 원하는 제품의 수량을 나타내는 정수 배열 number,
 * XYZ 마트에서 할인하는 제품을 나타내는 문자열 배열 discount가 주어졌을 때, 회원등록시 정현이가 원하는 제품을 모두 할인 받을 수 있는 회원등록 날짜의 총 일수를
 * return 하는 solution을 만들어라.
 *
 * 2. 사용 알고리즘
 *  - Sliding window & Hash map
 *
 *  3. 해결 방법
 *  - 10일 동안 정현이가 원하는 물건의 카운트와, 마트에서 할인하는 제품의 개수가 같은 경우에 answer 값을 +1 해준다.
 *
 *
 * */
public class 홍창모 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int answer = solution(want, number, discount);

        System.out.print(answer);
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        // want 배열의 원소를 key 값으로한 Hash Map을 선언
        HashMap<String, Integer> wantMap = new HashMap<>();

        // want와 number의 크기는 같다.
        for( int i = 0; i < want.length; i++ ) {
            wantMap.put(want[i], number[i]);
        }

        HashMap<String, Integer> discountMap = new HashMap<>();

        // 10일씩 잘라서 Map에 저장해준다.
        int lt = 0;
        for( int rt = 0; rt < discount.length; rt++ ) {
            discountMap.put(discount[rt], discountMap.getOrDefault(discount[rt], 0) + 1);

            if( rt - lt == 9 ) {
                // 10일이 되면 lt를 증가시켜서 10일을 유지한다.
                // discountMap의 크기와 wantMap의 Key Value가 같은지 확인한다.
                if( discountMap.size() == wantMap.size() ) {
                    if( equalsMap(wantMap, discountMap) ) {
                        answer++;
                    }
                }

                discountMap.put(discount[lt], discountMap.get(discount[lt]) - 1);

                if( discountMap.get(discount[lt]) == 0 ) {
                    discountMap.remove(discount[lt]);
                }

                lt++;
            }
        }

        return answer;
    }

    private static boolean equalsMap(HashMap<String, Integer> wantMap, HashMap<String, Integer> discountMap) {
        for( Map.Entry<String, Integer> entry : wantMap.entrySet() ) {
            if( discountMap.getOrDefault(entry.getKey(), 0) != entry.getValue() ) {
                return false;
            }
        }

        return true;
    }
}
