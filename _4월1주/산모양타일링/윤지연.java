package _4월1주.산모양타일링;

public class 윤지연 {
    public static void main(String[] args) {
        int n = 4;
        int[] tops = new int[]{1,1,0,1};

        System.out.println(solution(n, tops));
    }

    public static int solution(int n, int[] tops) {
        int mod = 10007;
        int total = 2 * n + 1;
        int[] dp = new int[total + 1];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= total; i++) {
            // 산 모양일 경우
            if (i % 2 == 0 && tops[(i - 1) / 2] == 1) {
                dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % mod;
            } else {  // 산 모양이 아닐 경우
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }
        return dp[total];
    }
}
