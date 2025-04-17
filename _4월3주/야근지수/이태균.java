package _4월3주.야근지수;


import java.util.PriorityQueue;

/**
 * 회사원 Demi는 가끔은 야근을 하는데요, 야근을 하면 야근 피로도가 쌓입니다.
 * 야근 피로도는 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값입니다.
 * Demi는 N시간 동안 야근 피로도를 최소화하도록 일할 겁니다.
 * Demi가 1시간 동안 작업량 1만큼을 처리할 수 있다고 할 때,
 * 퇴근까지 남은 N 시간과 각 일에 대한 작업량 works에 대해 야근 피로도를 최소화한 값을 리턴하는 함수 solution을 완성해주세요.
 */
public class 이태균 {

    public static void main(String[] args) {
        int[] works = {4, 3, 3}; // 각 작업마다 주어지는 작업량
        int n = 4;               // 일할 수 있는 시간

        long result = solution(n, works); // 최소화한 야근 피로도
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