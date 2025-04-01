package _3월4주.숫자의표현;

public class 이태균 {

    public static void main(String[] args) {
        int n = 15;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int answer = 0;
        int sum;
        int rt;

        for (int lt = 1; lt <= n; lt++) {
            sum = 0;
            rt = lt;

            while (sum <= n) {
                sum += rt;
                rt++;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

}