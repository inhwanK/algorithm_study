package algorithm_study.programers.level3;

// 순위 - https://school.programmers.co.kr/learn/courses/30/lessons/49191
public class Pro49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] board = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            board[winner][loser] = 1;
            board[loser][winner] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                        board[j][i] = -1;
                    }

                    if (board[i][k] == -1 && board[k][j] == -1) {
                        board[i][j] = -1;
                        board[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            int count = 0;
            for (int j = 1; j < n + 1; j++) {
                if (board[i][j] != 0) {
                    count++;
                }
            }

            if (count == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    // true, false 체크로 풀기
    public int solution2(int n, int[][] results) {
        int answer = 0;

        boolean[][] chk = new boolean[n + 1][n + 1];

        for(int i = 0; i < results.length; i++) {
            chk[results[i][0]][results[i][1]] = true;
        }

        for(int k = 1; k < n + 1; k++) {
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < n + 1; j++) {
                    if(i != j && chk[i][k] && chk[k][j]) {
                        chk[i][j] = true;
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            boolean pass = true;
            for(int j = 1; j < n + 1; j++) {
                if(i != j && !(chk[i][j] || chk[j][i])) {
                    pass = false;
                    break;
                }
            }
            if(pass) {
                answer++;
            }
        }

        return answer;
    }
}
