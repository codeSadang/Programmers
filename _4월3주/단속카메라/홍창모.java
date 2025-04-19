package _4월3주.단속카메라;

import java.util.Arrays;

/**
 * 1. 문제
 * 고속도로를 이용하는 모든 차량이 고속도로를 이용하면서 단속용 카메라를 한 번은 만날 수 있는 카메라의 최소 대수를 구해라
 *
 * 2. 제한사항
 * - 차량의 대수는 1대 이상 10,000대 이하입니다.
 * - routes에는 차량의 이동 경로가 포함되어 있으며 routes[i][0]에는 i번째 차량이 고속도로에 진입한 지점, routes[i][1]에는 i번째 차량이 고속도로에서 나간 지점이 적혀 있습니다.
 * - 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난것으로 간주합니다.
 * - 차량의 진입 지점, 진출 지점은 -30,000 이상 30,000 이하입니다.
 *
 * 3. 문제풀이
 * -
 * */
public class 홍창모 {
    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int answer = solution(routes);
        System.out.println(answer);
    }

    public static int solution(int[][] routes) {
        int answer = 0;

        // 차량의 진입 지점과 진출 지점을 기준으로 정렬
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                if (routes[i][0] > routes[j][0]) {
                    int[] temp = routes[i];
                    routes[i] = routes[j];
                    routes[j] = temp;
                } else if (routes[i][0] == routes[j][0] && routes[i][1] > routes[j][1]) {
                    // 차량의 진입 지점이 같을 경우, 진출 지점이 더 작은 차량이 먼저 정렬
                    int[] temp = routes[i];
                    routes[i] = routes[j];
                    routes[j] = temp;
                }
            }
        }

        Arrays.sort(routes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // 진입 지점 기준 오름차순
            } else {
                return Integer.compare(a[1], b[1]); // 진입 지점이 같다면 진출 지점 기준 오름차순
            }
        });

        // 차량의 진입 지점과 진출 지점이 정렬된 상태에서 카메라를 설치
        int camera = routes[0][1];
        answer++;

        for (int i = 1; i < routes.length; i++) {
            // 차량의 진입 지점이 카메라의 위치보다 크면 카메라를 추가
            if (routes[i][0] > camera) {
                camera = routes[i][1];
                answer++;
            } else {
                // 차량의 진입 지점이 카메라의 위치보다 작으면 카메라의 위치를 업데이트
                camera = Math.min(camera, routes[i][1]);
            }
        }

        return answer;
    }
}
