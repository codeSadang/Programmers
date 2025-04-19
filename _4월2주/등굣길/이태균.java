package _4월2주.등굣길;

public class 이태균 {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 1) {
                    dp[i][j] += dp[i][j - 1];
                }
                dp[i][j] %= 1_000_000_007;
            }
        }

        return dp[n][m];
    }

}