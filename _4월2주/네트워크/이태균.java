package _4월2주.네트워크;

import java.util.Stack;

public class 이태균 {

    public static boolean[] VISITED;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int result = solution(n, computers);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        VISITED = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!VISITED[node]) {
                dfs(node, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void dfs(int node, int n, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        VISITED[node] = true;

        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (int next = 0; next < n; next++) {
                if (computers[now][next] == 1 && !VISITED[next]) {
                    stack.push(next);
                    VISITED[next] = true;
                }
            }
        }
    }
}
