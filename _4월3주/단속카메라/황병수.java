package _4월3주.단속카메라;

import java.util.Arrays;

public class 황병수 {

    public static void main(String[] args) {
        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int answer = solution(routes);
        System.out.println(answer);
    }

    public static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); // 진입 지점 기준 오름차순
            } else {
                return Integer.compare(a[1], b[1]); // 진입 지점이 같다면 진출 지점 기준 오름차순
            }
        });

        // 차량의 진입 지점과 진출 지점이 정렬된 상태에서 카메라를 설치
        int camera = routes[0][1];

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
