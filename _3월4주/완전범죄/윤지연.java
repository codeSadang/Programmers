package _3월4주.완전범죄;

public class 윤지연 {
    /*
    * 문제 요약:
    * 두 도둑이 물건을 훔치며 흔적을 남긴다.
    * 물건은 무조건 두 도둑 중 한 명이 훔쳐야 한다.
    * 각 물건을 훔칠 때 남기는 흔적 개수가 정해져 있다.
    * A 도둑은 n개 이상 흔적이 남으면 잡히고, B도둑은  m개 이상 흔적이 남으면 잡힌다.
    * 목표: 두 도둑 모두 안 잡히고, A 도둑 흔적 수를 최소화하기
    * 풀이:
    * DP 활용
    * dp[i][j][k]:
    *
    * i번째 물건까지 훔쳤을 때, A의 흔적이 j개, B의 흔적이 k개인 상태가 가능한가를 나타내는 boolean 배열
    * DP 상태 전이
    * 각 물건을 A가 훔치는 경우와 B가 훔치는 경우로 나눈다.
    * dp[i-1][j][k] 가 true이면
    * 1. A, i 번째 물건 훔치는 경우
    *  -> j + info[i][0] < n (잡히지 않아야 함)
    *  -> dp[i][j + info[i][0]][k] = true;
    * 2. B, i 번째 물건 훔치는 경우
    *  -> k + info[i][1] < m (잡히지 않아야 함)
    *  -> dp[i][j][k + info[i][1]] = true;
    * 결과값 계산
    *
    * */
    public static void main(String[] args) {
        int[][] info = new int[][]{{1,2},{2,3},{2,1}};
        int n = 4;
        int m = 4;

        System.out.println(solution(info, n, m)); //2
    }

    public static int solution(int[][] info, int n, int m) {
        int len = info.length;
        boolean[][][] dp = new boolean[len + 1][n][m];

        dp[0][0][0] = true;

        for (int i = 0; i < len; i++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[i][a][b]) continue;

                    // A가 훔칠 때
                    int nextA = a + info[i][0];
                    if (nextA < n) {
                        dp[i + 1][nextA][b] = true;
                    }

                    // B가 훔칠 때
                    int nextB = b + info[i][1];
                    if (nextB < m) {
                        dp[i + 1][a][nextB] = true;
                    }
                }
            }
        }

        // 최소 A 흔적 찾기
        int minC = Integer.MAX_VALUE;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[len][a][b]) {
                    minC = Math.min(minC, a);
                }
            }
        }

        return minC == Integer.MAX_VALUE ? -1 : minC;
    }
}
