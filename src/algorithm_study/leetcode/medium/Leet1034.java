package algorithm_study.leetcode.medium;

import java.util.*;

// Coloring A Border - https://leetcode.com/problems/coloring-a-border/description/
public class Leet1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        List<ConnectedSquare> cand = searchConnectedComponent(grid, row, col);

        for (int i = cand.size() - 1; i >= 0; i--) {
            if (!cand.get(i).isBorder(grid)) cand.remove(i);
        }

        for (int i = 0; i < cand.size(); i++) {
            ConnectedSquare square = cand.get(i);
            grid[square.r][square.c] = color;
        }

        return grid;
    }

    // 경계 찾는 메서드 bfs
    private List<ConnectedSquare> searchConnectedComponent(int[][] grid, int row, int col) {
        Queue<ConnectedSquare> que = new LinkedList();
        que.add(new ConnectedSquare(row, col));
        List<ConnectedSquare> cand = new ArrayList();

        int[] dr = {0, 1, 0 , -1};
        int[] dc = {1, 0, -1 , 0};
        boolean[][] visited =  new boolean[grid.length][grid[0].length];
        visited[row][col] = true;

        while(!que.isEmpty()) {
            ConnectedSquare now = que.poll();
            cand.add(now);

            for (int dir = 0;  dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visited[nr][nc]) {
                    continue;
                }

                if(grid[now.r][now.c] != grid[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                ConnectedSquare square = new ConnectedSquare(nr, nc);
                que.add(square);
            }
        }

        return cand;
    }
}

class ConnectedSquare {
    int r;
    int c;

    public ConnectedSquare(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean isBorder(int[][] grid) {
        int[] dr = {0, 1, 0 , -1};
        int[] dc = {1, 0, -1 , 0};

        for (int dir = 0;  dir < 4; dir++) {
            int nr = this.r + dr[dir];
            int nc = this.c + dc[dir];

            if((nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) || (grid[this.r][this.c] != grid[nr][nc])) {
                return true;
            }
        }
        return false;
    }
}

class Leet1034_2 {
    // 상하좌우
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int orig = grid[row][col];
        boolean[][] visited = new boolean[m][n];

        // 경계 칠할 좌표만 모아두기
        List<int[]> borders = new ArrayList<>();

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            int sameAdj = 0; // 같은 색으로 이어진 인접 수

            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k], nc = c + DC[k];

                // 격자 밖이면 경계 조건 충족 가능성 ↑ (단, sameAdj 계산에는 포함 X)
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                if (grid[nr][nc] == orig) {
                    sameAdj++;
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }

            // 경계 판정:
            // 1) 격자 가장자리이거나
            // 2) 상하좌우 중 같은 색이 아닌 칸이 하나라도 있는 경우(= 같은 색 이웃이 4 미만)
            if (r == 0 || r == m - 1 || c == 0 || c == n - 1 || sameAdj < 4) {
                borders.add(cur);
            }
        }

        // 경계만 새 색으로 칠하기 (원본 컴포넌트 내부는 색 유지)
        for (int[] p : borders) {
            grid[p[0]][p[1]] = color;
        }

        return grid;
    }
}
