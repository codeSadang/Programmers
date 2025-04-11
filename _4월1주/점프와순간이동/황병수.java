package _4월1주.점프와순간이동;


import java.util.PriorityQueue;

/**
 * 한 번에 k 칸을 앞으로 점프하거나
 * 현재까지 온 거리 x2 에 해당하는 위칠 순간이동할 수 있다.
 * 순간이동을 하면 건전지 사용량이 줄지 않지만,
 * 앞으로 k칸을 점프하면 k만큼의 건전지 사용량이 든다.
 *
 *
 */
public class 황병수 {

    public static void main(String[] args) {
        int N = 6;
        System.out.println(solution(N));
    }

    private static int solution(int s) {
        int ans = 0;
        while (s > 0) {
            if (s % 2 == 0) {
                s /= 2; // 순간이동
            } else {
                s -= 1; // 점프 (건전지 사용)
                ans++;  // 사용량 증가
            }
        }
        return ans;
    }
}
