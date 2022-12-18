package algorithm_study.programers.level2;

// 쿼드압축 후 개수 세기 - https://school.programmers.co.kr/learn/courses/30/lessons/68936
public class Pro68936 {
    int[] result = new int[2];

    public int[] solution(int[][] arr) {

        dfs(arr, 0, 0, arr.length);
        return result;
    }

    public void dfs(int[][] arr, int row, int col, int size) {

        if (check(arr, row, col, size)) {
            result[arr[row][col]]++;
            return;
        }

        dfs(arr, row, col, size / 2);
        dfs(arr, row, col + (size / 2), size / 2);
        dfs(arr, row + (size / 2), col, size / 2);
        dfs(arr, row + (size / 2), col + (size / 2), size / 2);
    }


    public boolean check(int[][] arr, int row, int col, int size) {
        int target = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != target) {
                    return false;
                }
            }
        }

        return true;
    }
}
