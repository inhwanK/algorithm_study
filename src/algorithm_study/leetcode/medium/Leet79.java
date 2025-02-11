package algorithm_study.leetcode.medium;

// Word Search - https://leetcode.com/problems/word-search/description/
public class Leet79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int index, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return false;
        }

        if (word.charAt(index) != board[x][y]) {
            return false;
        }

        visited[x][y] = true;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int dir = 0; dir < 4; dir++) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (dfs(board, nx, ny, index + 1, word, visited)) {
                return true;
            }
        }

        visited[x][y] = false;
        return false;
    }
}
