package algorithm_study.leetcode.medium;

import java.util.*;

// 3619. Count Islands With Total Value Divisible by K - https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet3619 {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || visited[i][j]) continue;

                long sum = 0;
                visited[i][j] = true;
                q.addLast(new int[]{i, j});

                while (!q.isEmpty()) {
                    int[] cur = q.pollFirst();
                    int x = cur[0], y = cur[1];
                    sum += grid[x][y];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (grid[nx][ny] == 0 || visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        q.addLast(new int[]{nx, ny});
                    }
                }

                if (sum % k == 0) result++;
            }
        }
        return result;
    }
}
