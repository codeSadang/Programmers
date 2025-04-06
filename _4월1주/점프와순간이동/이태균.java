package _4월1주.점프와순간이동;

public class 이태균 {

    public static void main(String[] args) {
        int n = 6;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }

        return answer;
    }

}