package _4월1주.산모양타일링;

import java.util.Arrays;

public class 황병수dp {

    public static void main(String[] args) {

        int n = 4;
        int[] tops = new int[]{1,1,0,1};

//        int n = 2;
//        int[] tops = new int[]{0,1};

//        int n = 10;
//        int[] tops = new int[]{0,0,0,0,0,0,0,0,0,0};

        solution(n, tops);
    }

    private static void solution(int n, int[] tops) {

        int[][] maps = new int[2][(n+1) * 2];
        for (int i = 1; i < maps[0].length; i++) {
            maps[1][i] = 1;
        }

        for (int i = 1; i <= tops.length; i++) {
            if (tops[i-1] == 1) maps[0][i * 2] = 1;
        }

        System.out.println(dp(maps));
    }

    private static int dp(int[][] maps) {
        int size = maps[0].length;
        int[] dp = new int[size];
        dp[1] = 1;

        for (int nowIndex = 1; nowIndex < size; nowIndex++) {
            // 인덱스가 짝수
            if (nowIndex % 2 == 0) {

                // 다이아몬드
                if (maps[0][nowIndex] == 1 && nowIndex + 1 < size) {
                    dp[nowIndex + 1] += dp[nowIndex] % 10007;
                }

                // 그냥 삼각형
                if (nowIndex + 1 < size) dp[nowIndex + 1] += dp[nowIndex] % 10007;

                // 오른쪽아래 사다리꼴
                if (nowIndex + 2 < size) dp[nowIndex + 2] += dp[nowIndex] % 10007;

                // 오른쪽아래 사다리꼴
                if (nowIndex + 2 == size) dp[nowIndex + 1] += dp[nowIndex] % 10007;
            }

            // 인덱스가 홀수
            else {
                // 그냥 삼각형
                if (nowIndex + 1 < size) dp[nowIndex + 1] += dp[nowIndex] % 10007;

                // 오른쪽아래 사다리꼴
                if (nowIndex + 2 < size) dp[nowIndex + 2] += dp[nowIndex] % 10007;
            }
        }

        return dp[size - 1] % 10007;
    }
}
