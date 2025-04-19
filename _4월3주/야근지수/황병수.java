package _4월3주.야근지수;

import java.util.PriorityQueue;
public class 황병수 {

    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;

        long result = solution(n, works);
        System.out.println(result);
    }

    public static long solution(int n, int[] works) {
        long answer = 0;

        // 최대 힙으로 변환 (내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // 작업량을 큐에 넣기
        for (int work : works) {
            pq.offer(work);
        }

        // n 시간이 주어졌을 때, 가장 큰 작업부터 하나씩 감소시키기
        while (n > 0 && !pq.isEmpty()) {
            int nowWork = pq.poll();
            if (nowWork > 0) {
                pq.offer(nowWork - 1);  // 작업량을 1만큼 감소시키고 다시 큐에 넣음
                n--;  // 1시간 작업함
            }
        }

        // 남은 작업들의 제곱의 합을 구함
        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }

}