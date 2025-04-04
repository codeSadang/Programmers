package _4월1주.정수삼각형;

public class 이태균 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution(triangle);
        System.out.println(result);
    }

    public static int solution(int[][] triangle) {
        // 뒤에서부터 계산하면서 삼각형 배열을 직접 업데이트
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                // 다음 행에서 두 개의 선택지 중 더 큰 값을 더합니다.
                triangle[row][col] += Math.max(triangle[row + 1][col], triangle[row + 1][col + 1]);
            }
        }

        // 최종적으로 triangle[0][0]에 최적 경로 합이 들어 있습니다.
        return triangle[0][0];
    }
}
