package _4월1주.산모양타일링;

import java.util.Arrays;

public class 황병수bfs {

    static int count = 0;

    public static void main(String[] args) {

        int n = 4;
        int[] tops = new int[]{1,1,0,1};

//        int n = 2;
//        int[] tops = new int[]{0,1};

//        int n = 10;
//        int[] tops = new int[]{0,0,0,0,0,0,0,0,0,0};

        solution(n, tops);
    }

    private static void solution(int n, int[] tops) {

        int[][] maps = new int[2][(n+1) * 2];
        for (int i = 1; i < maps[0].length; i++) {
            maps[1][i] = 1;
        }

        for (int i = 1; i <= tops.length; i++) {
            if (tops[i-1] == 1) maps[0][i * 2] = 1;
        }

        System.out.println(bfs(1, maps));
    }

    private static int bfs(int nowIndex, int[][] maps) {
        int size = maps[0].length;
        if (nowIndex == size - 1) {
            return 1;
        }

        int count = 0;

        // 인덱스가 짝수
        if (nowIndex % 2 == 0) {
            // 다이아몬드
            if (maps[0][nowIndex] == 1 && nowIndex + 1 < size) count += bfs(nowIndex + 1, maps);

            // 삼각형
            if (nowIndex + 1 < size) count += bfs(nowIndex + 1, maps);

            // 오른쪽아래 사다리꼴
            if (nowIndex + 2 < size) count += bfs(nowIndex + 2, maps);
            if (nowIndex + 2 == size) count += bfs(nowIndex + 1, maps);
        }

        // 인덱스가 홀수
        else {
            // 삼각형
            if (nowIndex + 1 < size) count += bfs(nowIndex + 1, maps);

            // 오른쪽아래 사다리꼴
            if (nowIndex + 2 < size) count += bfs(nowIndex + 2, maps);
        }

        return count % 10007;
    }
}
