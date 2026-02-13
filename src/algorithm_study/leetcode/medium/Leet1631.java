package algorithm_study.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// 1631. Path With Minimum Effort - https://leetcode.com/problems/path-with-minimum-effort/description/
public class Leet1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0], r = cur[1], c = cur[2];

            if(effort != dist[r][c]) continue;

            if(r == m - 1 && c == n - 1) return effort;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                int edge = Math.abs(heights[r][c] - heights[nr][nc]);
                int nextEffort = Math.max(effort, edge);

                if(nextEffort < dist[nr][nc]) {
                    dist[nr][nc] = nextEffort;
                    pq.add(new int[]{nextEffort, nr, nc});
                }
            }
        }
        return 0;
    }
}
