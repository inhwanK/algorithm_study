package algorithm_study.programers.level2;

import java.util.*;

// 행렬 테두리 회전하기 - https://school.programmers.co.kr/learn/courses/30/lessons/77485
public class Pro77485 {
    int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {

        board = new int[rows][columns];

        int value = 1;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = value;
                value++;
            }
        }
        // ------

        ArrayList<Integer> result = new ArrayList();

        for (int[] query : queries) {
            result.add(rotate(query));
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    // 두 점을 네 점으로 바꾸기
    private int rotate(int[] query) {
        Queue<int[]> q = new LinkedList();
        ArrayList<Integer> values = new ArrayList();

        for(int i = query[1]; i < query[3]; i++) {
            int[] loc = {query[0] - 1, i - 1};
            q.add(loc);
            values.add(board[loc[0]][loc[1]]);
        }

        for(int i = query[0]; i < query[2]; i++) {
            int[] loc = {i - 1, query[3] - 1};
            q.add(loc);
            values.add(board[loc[0]][loc[1]]);
        }

        for(int i = query[3]; i > query[1]; i--) {
            int[] loc = {query[2] - 1, i - 1};
            q.add(loc);
            values.add(board[loc[0]][loc[1]]);
        }

        for(int i = query[2]; i > query[0]; i--) {
            int[] loc = {i - 1, query[1] - 1};
            q.add(loc);
            values.add(board[loc[0]][loc[1]]);
        }

        q.add(q.poll());

        int min = Integer.MAX_VALUE;

        int index = 0;
        while(!q.isEmpty()) {
            int[] target = q.poll();
            board[target[0]][target[1]] = values.get(index);
            min = Math.min(min, values.get(index));
            index++;
        }

        return min;
    }

}
