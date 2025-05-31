package _5월4주.홍창모_스킬체크;

import java.util.Arrays;

public class 문제2 {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789", "1234"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        // 전화번호를 정렬
        Arrays.sort(phone_book);

        // 인접한 전화번호끼리 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                // 접두사인 경우 false 반환
                return false;
            }
        }

        // 모든 전화번호가 접두사가 아닌 경우 true 반환
        return true;
    }
}
