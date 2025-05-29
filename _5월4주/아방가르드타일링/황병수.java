package _5월4주.아방가르드타일링;

import java.util.*;

public class 황병수 {

    // 아방가르드타일
    public static void main(String[] args) {

        int n = 5;

        int solution = solution(n);
        System.out.println("solution = " + solution);

    }

    public static int solution(int n) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n+1];
        long[] dp4 = new long[n + 1];
        long[] dp5 = new long[n + 1];
        long[] dp6 = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if(i >= 1) dp[i] += dp[i-1];
            if(i >= 2) dp[i] += dp[i-2] * 2 % MOD;
            if(i >= 3) dp[i] += dp[i-3] * 5 % MOD;
            if(i >= 4) {
                long diff = (dp[i - 4] * 2) % MOD;
                dp4[i] = (dp4[i-3] + diff) % MOD;
                dp[i] += dp4[i] % MOD;
            }

            if(i >= 5) {
                long diff = (dp[i - 5] * 2) % MOD;
                dp5[i] = (dp5[i-3] + diff) % MOD;
                dp[i] += dp5[i] % MOD;
            }

            if(i >= 6) {
                long diff = (dp[i - 6] * 4) % MOD;
                dp6[i] = (dp6[i-3] + diff) % MOD;
                dp[i] += dp6[i] % MOD;
            }
            dp[i] = dp[i] % MOD;
        }

        return Math.toIntExact(dp[n]);
    }
}
