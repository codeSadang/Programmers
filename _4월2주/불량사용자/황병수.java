package _4월2주.불량사용자;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class 황병수 {

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int answer = solution(user_id, banned_id);
        System.out.print(answer);
    }

    private static int solution(String[] user_id, String[] banned_id) {
        return dfs(user_id, banned_id);
    }

    private static int dfs(String[] user_id, String[] banned_id) {

        class Node {
            int depth;
            boolean[] visited;
            ArrayList<String> currentSet;

            Node(int depth, boolean[] visited, ArrayList<String> currentSet) {
                this.depth = depth;
                this.visited = visited;
                this.currentSet = currentSet;
            }
        }

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(0, new boolean[user_id.length], new ArrayList<>()));

        HashSet<HashSet<String>> resultSet = new HashSet<>();

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (current.depth == banned_id.length) {

                for (HashSet<String> strings : resultSet) {
                    System.out.println("strings = " + strings);
                }
                resultSet.add(new HashSet<>(current.currentSet));
                continue;
            }

            for (int i = 0; i < user_id.length; i++) {
                if (!current.visited[i] && invalidation(banned_id[current.depth], user_id[i])) {
                    boolean[] nextVisited = current.visited.clone();
                    nextVisited[i] = true;
                    ArrayList<String> nextSet = new ArrayList<>(current.currentSet);
                    nextSet.add(user_id[i]);
                    stack.push(new Node(current.depth + 1, nextVisited, nextSet));
                }
            }
        }

        return resultSet.size();
    }

    private static boolean invalidation(String banned, String user) {
        if (banned.length() != user.length()) return false;

        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }
}
