package _4월2주.등굣길;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 황병수 {
    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};

        System.out.println(solution(m,n,puddles));
    }

    private static int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;
        int[][] paths = new int[n + 1][m + 1];
        boolean[][] isPuddle = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            isPuddle[y][x] = true;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,1});
        paths[1][1] = 1;

        int[] dx = {1, 0};
        int[] dy = {0, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];

            for (int i = 0; i < 2; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny > n || nx > m) continue;
                if (isPuddle[ny][nx]) continue;

                if (paths[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                }

                paths[ny][nx] = (paths[ny][nx] + paths[y][x]) % MOD;
            }
        }

        return paths[n][m];
    }
}
