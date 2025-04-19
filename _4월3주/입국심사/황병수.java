package _4월3주.입국심사;

import java.util.Arrays;

public class 황병수 {

    public static void main(String[] args) {
        int n = 6;
        int[] times = new int[]{7,10};

        long solution = solution(n, times);
        System.out.println("solution = " + solution);
    }

    static long solution(int n, int[] times) {
        Arrays.sort(times); // 심사 시간 오름차순 정렬

        long left = 1; // 최소 시간
        long right = (long) times[times.length - 1] * n; // 가장 오래 걸리는 심사관 기준 최댓값
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 시간 동안 몇 명 심사 가능한지 계산
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                // 사람 수를 충족하면 시간 줄여보기
                answer = mid;
                right = mid - 1;
            } else {
                // 부족하면 시간 늘려야 함
                left = mid + 1;
            }
        }

        return answer;
    }
}
