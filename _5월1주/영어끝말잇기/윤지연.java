package _5월1주.영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

public class 윤지연 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            Set<String> wordList = new HashSet<>();

            for (int i = 0; i < words.length; i++) {
                int turn = (i % n) + 1;
                int round = (i / n) + 1;
                String word = words[i];

                // 복 단어 또는 끝말잇기 규칙 검사
                if (wordList.contains(words[i])) {
                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;
                }

                if (i > 0) {
                    String prev = words[i - 1];
                    String curr = words[i];
                    char prevWord = prev.charAt(prev.length() - 1);
                    char currWord = curr.charAt(0);
                    // 2. 끝말잇기 규칙
                    if (prevWord != currWord) {
                        answer[0] = (i % n) + 1;
                        answer[1] = (i / n) + 1;
                        break;
                    }
                }
                wordList.add(words[i]);
            }
            return answer;
        }
    }
}
