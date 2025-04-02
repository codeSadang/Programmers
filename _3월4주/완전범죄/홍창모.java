package _3월4주.완전범죄;

import java.util.Arrays;

/**
 * 1. 각 도둑이 i 번째 물건을 훔쳤을때, 남기는 흔적
 * A도둑 : info[i][0]개의 흔적을 남긴다.
 * B도둑 : info[i][1]개의 흔적을 남긴다.
 *
 * 2. 경찰에 붙잡히는 조건
 * A 도둑과 B 도둑이 훔친 물건의 합이 각각 n, m을 넘어가면 경찰에 붙잡힌다.
 *
 * 3. 문제
 * A도둑이 남긴 흔적의 누적 개수가 최소인 경우를 return
 * 두 도둑 모두 경찰에 붙잡히지 않게 할 수 없다면 -1을 return
 * */
public class 홍창모 {
    public static void main(String[] args) {
        /*int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4;
        int m = 4;*/

        int[][] info = {{3,3}, {3,3}};
        int n = 7;
        int m = 1;

        int answer = solution(info, n, m);

        System.out.print(answer);
    }

    public static int solution(int[][] info, int n, int m) {
        int minA = Integer.MAX_VALUE;

        int[][] dp = new int[info.length + 1][m];

        for(int i = 0; i <= info.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for(int i = 1; i <= info.length; i++) {
            int a = info[i - 1][0];
            int b = info[i - 1][1];

            for(int j = 0; j < m; j++) {
                // 오버플로우 방지를 위한 조건 추가
                if(dp[i-1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                }

                if(j + b < m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            minA = Math.min(dp[info.length][i], minA);
        }

        return minA >= n ? -1 : minA;
    }
}
