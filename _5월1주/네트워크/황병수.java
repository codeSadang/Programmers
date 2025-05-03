package _5월1주.네트워크;

import java.util.ArrayDeque;

public class 황병수 {

    public static void main(String[] args) {

        int n = 3;
//        int[][] computers = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] computers = new int[][]{{1,1,0}, {1,1,1}, {0,1,1}};

        System.out.println( solution(n, computers));
    }

    private static int solution(int n, int[][] computers) {

        boolean[] visited = new boolean[n];
        int result = 0;


        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            bfs(i, n, computers, visited);
            result++;
        }

        return result;
    }

    private static void bfs(int nowIndex, int n, int[][] computers, boolean[] visited) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(nowIndex);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            for (int j = 0; j < n; j++) {

                if (!visited[j] && computers[pop][j] == 1) {
                    stack.push(j);
                    visited[j] = true;
                }
            }
        }
    }
}
