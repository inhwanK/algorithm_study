package algorithm_study.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

// [1차] 프렌즈 4블록 - https://school.programmers.co.kr/learn/courses/30/lessons/17679
public class Pro17679 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean flag = true;
        while (flag) {
            boolean[][] v = new boolean[m][n];
            flag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] == '#') {
                        continue;
                    }

                    if (check(i, j, map)) {
                        v[i][j] = true;
                        v[i][j + 1] = true;
                        v[i + 1][j] = true;
                        v[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }
            answer += erase(m, n, v, map);
        }

        return answer;
    }

    public int erase(int m, int n, boolean[][] v, char[][] map) {
        int count = 0;

        for (int j = 0; j < n; j++) {
            Queue<Character> que = new LinkedList();
            for (int i = m - 1; i >= 0; i--) {
                if (v[i][j]) {
                    count++;
                    continue;
                }

                que.add(map[i][j]);
            }

            int index = m - 1;
            while (!que.isEmpty()) {
                map[index--][j] = que.poll();
            }

            for (int mod = index; mod >= 0; mod--) {
                map[mod][j] = '#';
            }
        }
        return count;
    }

    public boolean check(int x, int y, char[][] board) {
        char ch = board[x][y];
        if (ch == board[x][y + 1] && ch == board[x + 1][y] && ch == board[x + 1][y + 1]) {
            return true;
        }
        return false;
    }
}
