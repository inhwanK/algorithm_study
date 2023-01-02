package algorithm_study.programers.level2;

// 삼각 달팽이 - https://school.programmers.co.kr/learn/courses/30/lessons/68645
public class Pro68645 {
    public int[] solution(int n) {

        int[][] arr = new int[n][n];
        int size = (n * (n + 1)) / 2;

        int[] dirX = {1, 0, -1};
        int[] dirY = {0, 1, -1};
        int x = -1;
        int y = 0;

        int dir = 0;
        int count = 1;

        while (count <= size) {

            int nx = x + dirX[dir];
            int ny = y + dirY[dir];

            if (dir == 0 && (nx == n || arr[nx][ny] != 0)) {
                dir = 1;
                continue;
            }

            if (dir == 1 && (ny == nx + 1 || arr[nx][ny] != 0)) {
                dir = 2;
                continue;
            }

            if (dir == 2 && (arr[nx][ny] != 0)) {
                dir = 0;
                continue;
            }

            arr[nx][ny] = count;

            x = nx;
            y = ny;
            count++;
        }

        int[] answer = new int[size];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    break;
                }

                answer[index] = arr[i][j];
                index++;
            }
        }

        return answer;
    }

    public int[] solution_answer(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}
