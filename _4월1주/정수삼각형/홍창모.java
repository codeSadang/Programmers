package _4월1주.정수삼각형;

public class 홍창모 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};

        int answer = solution(triangle);

        System.out.print(answer);
    }

    public static int solution(int[][] triangle) {
        int answer = 0;

        for( int i = triangle.length - 2; i >= 0; i-- ) {
            for( int j = 0; j < triangle[i].length; j++ ) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        answer = triangle[0][0];

        return answer;
    }
}
