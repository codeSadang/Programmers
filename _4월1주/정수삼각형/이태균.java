package _4월1주.정수삼각형;

public class 이태균 {

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = solution(triangle);
        System.out.println(result);
    }

    public static int solution(int[][] triangle) {
        // DP 알고리즘 상향식(bottom-up) 접근법
        // 뒤에서부터 계산하면서 삼각형 배열을 직접 업데이트
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                // 다음 행에서 두 개의 선택지 중 더 큰 값을 더합니다.
                triangle[row][col] += Math.max(triangle[row + 1][col], triangle[row + 1][col + 1]);
            }
        }

        // 전체 삼각형에서 가능한 최대 경로의 합이 저장
        return triangle[0][0];
    }
}
