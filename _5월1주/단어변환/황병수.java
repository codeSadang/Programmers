package _5월1주.단어변환;

import java.util.ArrayDeque;

public class 황병수 {
    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    private static int solution(String begin, String target, String[] words) {
        int result = 0;
        int count = 0;
        boolean[] visited = new boolean[words.length];
        int length = begin.length();


        // 만약에 일치하는 단어가 없는 경우
        for (String word : words) {
            if (!target.equals(word)) count++;
        }
        if (count == words.length) return 0;

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.add(new Node(0, begin));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            String nowWord = poll.word;
            int nowDepth = poll.depth;

            String[] splitPoll = nowWord.split("");

            for (int i = 0; i < words.length; i++) {

                if (nowWord.equals(target)) return nowDepth;

                if (!visited[i]) {
                    String[] splitWord = words[i].split("");

                    int matchCount = 0;
                    for (int j = 0; j < length; j++) {
                        if (splitWord[j].equals(splitPoll[j])) matchCount++;
                    }

                    // 조건에 부합하면 방문체크한 후 queue 추가
                    if (matchCount == (length -1)) {
                        queue.add(new Node(nowDepth + 1, words[i]));
                        visited[i] = true;
                    }
                }
            }
        }
        return result;

    }

    public static class Node {
        int depth;
        String word;

        public Node(int depth, String word) {
            this.depth = depth;
            this.word = word;
        }
    }
}
