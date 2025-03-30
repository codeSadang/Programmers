package _3월4주.할인행사;

import java.util.HashMap;

public class 황병수 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));
    }

    private static int solution(String[] want, int[] number, String[] discount) {

        HashMap<String, Integer> myBag = new HashMap<>();
        int result = 0;

        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            myBag.put(item, myBag.getOrDefault(item, 0) + 1);
            if (check(myBag, want, number)) result++;
        }

        for (int i = 10; i < discount.length; i++) {

            String deItem = discount[i-10];
            String newItem = discount[i];

            myBag.put(deItem, myBag.get(deItem) - 1);
            myBag.put(newItem, myBag.getOrDefault(newItem, 0) + 1);

            if (check(myBag, want, number)) result++;
        }

        return result;
    }

    private static boolean check(HashMap<String, Integer> myBag, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (myBag.getOrDefault(want[i], 0) != number[i]) return false;
        }

        return true;
    }


}
