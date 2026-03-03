package algorithm_study.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 1462. Course Schedule IV - https://leetcode.com/problems/course-schedule-iv/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> answer = new ArrayList();

        boolean[][] board = new boolean[numCourses][numCourses];
        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            board[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < board.length; k++) {
                    if (board[j][i] && board[i][k]) {
                        board[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            boolean flag = false;
            if (board[queries[i][0]][queries[i][1]]) {
                flag = true;
            }
            answer.add(flag);
        }


        return answer;
    }
}
