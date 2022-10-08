package algorithm_study.programers.level1;

import java.util.*;
// 크레인 인형뽑기 게임 - https://school.programmers.co.kr/learn/courses/30/lessons/64061
public class Pro64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < moves.length; i++) {
            int num = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][num] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][num]);
                    } else {
                        if (stack.peek() == board[j][num]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[j][num]);
                        }
                    }

                    board[j][num] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
