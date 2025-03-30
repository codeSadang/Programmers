package _3월4주.완전범죄;

import java.util.ArrayDeque;

public class 황병수 {

    public static void main(String[] args) {
        int[][] info = new int[][]{{1,2},{2,3},{2,1}};
        int n = 4;
        int m = 4;

        System.out.println(solution(info, n, m));
    }

    static public int solution(int[][] info, int n, int m) {
        int minA = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[info.length + 1][n + 1][m + 1];
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{0, 0, 0}); // ← 여기 수정됨

        while (!stack.isEmpty()) {
            int[] pick = stack.pollLast();
            int idx = pick[0];
            int A = pick[1];
            int B = pick[2];

            if (A >= n || B >= m) continue;
            if (visited[idx][A][B]) continue;
            visited[idx][A][B] = true;

            if (idx == info.length) {
                minA = Math.min(minA, A);
                continue;
            }

            int nextA = A + info[idx][0];
            int nextB = B + info[idx][1];

            // A 도둑이 훔치는 경우
            if (nextA <= n && nextA < minA) {
                stack.addLast(new int[]{idx + 1, nextA, B});
            }

            // B 도둑이 훔치는 경우
            if (nextB < m) {
                stack.addLast(new int[]{idx + 1, A, nextB});
            }
        }
        return (minA == Integer.MAX_VALUE) ? -1 : minA;
    }
}
