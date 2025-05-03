package _4월2주.불량사용자;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class 황병수 {

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int answer = solution(user_id, banned_id);
        System.out.println(answer);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        Set<Set<String>> result = new HashSet<>();
        dfs(user_id, banned_id, new boolean[user_id.length], 0, new HashSet<>(), result);
        return result.size();
    }

    // DFS로 경우의 수 탐색
    private static void dfs(String[] user_id, String[] banned_id, boolean[] visited,
                            int depth, Set<String> currentSet, Set<Set<String>> result) {

        if (depth == banned_id.length) {
            // 완성된 조합을 result에 추가
            result.add(new HashSet<>(currentSet)); // 중복 제거 위해 복사본 저장
            return;
        }

        String pattern = banned_id[depth].replace("*", ".");

        for (int i = 0; i < user_id.length; i++) {
            if (!visited[i] && Pattern.matches(pattern, user_id[i])) {
                visited[i] = true;
                currentSet.add(user_id[i]);

                dfs(user_id, banned_id, visited, depth + 1, currentSet, result);

                visited[i] = false;
                currentSet.remove(user_id[i]);
            }
        }
    }
}