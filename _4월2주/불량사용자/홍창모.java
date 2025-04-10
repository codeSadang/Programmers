package _4월2주.불량사용자;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.regex.Pattern.matches;
/**
 * 풀이방법
 * 1. dfs를 이용하여 모든 경우의 수를 구한다.
 * 2. 정규식 matches를 이용하여 user_id와 banned_id의 패턴을 비교한다.
 * */
public class 홍창모 {

    private static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int answer = solution(user_id, banned_id);
        System.out.print(answer);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        boolean[] visited = new boolean[user_id.length];

        for( int i = 0; i < banned_id.length; i++ ) {
            // 정규식 형태로 치환
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        dfs(user_id, banned_id, visited, 0, "");

        // 중복된 경우의 수를 제거하기 위해 set을 사용
        // set의 크기를 answer에 저장
        answer = set.size();

        return answer;
    }

    public static void dfs(String[] user_id, String[] banned_id, boolean[] visited, int depth, String str) {
        if(depth == banned_id.length) {
            // 제재 아이디를 리스트화
            String[] s = str.split(" ");
            Arrays.sort(s);

            // 제재 아이디를 정렬하여 set에 저장
            StringBuilder sb = new StringBuilder();
            for( String as : s ) {
                sb.append(as);
            }
            str = sb.toString();

            set.add(str);
            return;
        }

        for(int i = 0; i < user_id.length; i++) {
            if(!visited[i] && matches(banned_id[depth], user_id[i])) {
                visited[i] = true;
                dfs(user_id, banned_id, visited, depth + 1, str + " " + user_id[i]);
                visited[i] = false;
            }
        }
    }
}
