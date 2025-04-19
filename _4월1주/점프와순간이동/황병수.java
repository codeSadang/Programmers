package _4월1주.점프와순간이동;

public class 황병수 {

    public static void main(String[] args) {
        int N = 6;
        System.out.println(solution(N));
    }

    private static int solution(int s) {
        int ans = 0;
        while (s > 0) {
            if (s % 2 == 0) {
                s /= 2; // 순간이동
            } else {
                s -= 1; // 점프 (건전지 사용)
                ans++;  // 사용량 증가
            }
        }
        return ans;
    }
}
