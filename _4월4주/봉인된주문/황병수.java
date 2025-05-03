package _4월4주.봉인된주문;

public class 황병수 {

    public static void main(String[] args) {


        int n = 7388;
        String[] bans = {"d", "e", "bb", "aa", "ae"};

        solution(n, bans);

    }

    private static void solution(int n, String[] bans) {

        int tempN = n;
        int size = 1;

        while (true) {
            if (tempN > 26) {
                tempN /= 26;
                size++;
            } else {
                break;
            }
        }

        System.out.println(size);


        int count = 0;
        for (String ban : bans) {
            int length = ban.length() - 1;
            String[] split = ban.split("");

            for (int i = length; i > 0; i--) {

            }
        }
    }
}
