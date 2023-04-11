package algorithm_study.leetcode.easy;

import java.util.*;

// Pascal's Triangle 2 - https://leetcode.com/problems/pascals-triangle-ii/description/?envType=study-plan&id=data-structure-ii
public class Leet119 {
    public List<Integer> getRow(int rowIndex) {
        // 0 - 1 = 1
        // 1 - 1 / 1 = 2
        // 2 - 1, 2 / 1 = 4
        // 3 - 1, 3 / 3, 1 = 8
        // 4 - 1, 4, 6 / 4, 1 = 16
        // 5 - 1, 5, 10 / 10, 5, 1 = 32
        // 6 - 1, 6, 15, 20 / 15, 6, 1 = 64 -
        // 7 - 1, 7, 21, 35 / 35, 21, 7, 1 = 128

        int[][] answer = new int[rowIndex + 1][rowIndex + 2];
        answer[0][0] = 1;
        int count = 0;
        for (int i = 1; i <= rowIndex; i++) {
            answer[i][0] = 1;
            answer[i][i] = 1;
            for (int j = 1; j < i; j++) {
                answer[i][j] = answer[i - 1][j - 1] + answer[i - 1][j];
            }
        }

        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(answer[rowIndex][i]);
        }
        return list;
    }
}
