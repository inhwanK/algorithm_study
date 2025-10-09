package algorithm_study.programers.level3;

// 보행자 천국 - https://school.programmers.co.kr/learn/courses/30/lessons/1832
public class Pro1832 {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        // dp로...
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) {
                break;
            }
            right[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) {
                break;
            }
            down[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    continue;
                }

                if (cityMap[i][j - 1] == 1) {
                    right[i][j] = 0;
                } else if (cityMap[i][j - 1] == 2) {
                    right[i][j] = right[i][j - 1];
                } else {
                    right[i][j] = (right[i][j - 1] + down[i][j - 1]) % MOD;
                }

                if (cityMap[i - 1][j] == 1) {
                    down[i][j] = 0;
                } else if (cityMap[i - 1][j] == 2) {
                    down[i][j] = down[i - 1][j];
                } else {
                    down[i][j] = (down[i - 1][j] + right[i - 1][j]) % MOD;
                }
            }
        }

        answer = (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD;

        return answer;
    }
}
