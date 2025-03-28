package 여행경로;

import java.util.*;

/**
 * 1. 문제
 * - 문제 설명
 *      주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
 *      항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * - 제한사항
 *  # 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
 *  # 주어진 공항 수는 3개 이상 10,000개 이하입니다.
 *  # tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미입니다.
 *  #주어진 항공권은 모두 사용해야 합니다.
 *  # 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
 *  # 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
 *
 * 2. 문제풀이
 *  - DFS를 이용하여 풀이
 *  - 알파벳 순서대로 정렬 >  Comparator를 사용하여 정렬
 *  - boolean 타입의 visited 배열을 사용하여 방문한 곳인지 확인
 * - 시작점은 항상 ICN이므로 ICN을 시작으로 dfs를 시작
 *
 * 3. 시간 복잡도
 * - O(N^2)
 * - N은 tickets의 길이
 * - 모든 티켓을 다 사용해야 하므로 N^2
 * */
public class 홍창모 {

    static boolean[] visited;
    static List<String> answers;

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution(tickets);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];

        // ticket 정보를 알파벳 순서대로 정렬
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        dfs("ICN", "ICN", tickets, 0);

        // 결과값 알파벳 순서대로 정렬
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    public static void dfs(String current, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            answers.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}