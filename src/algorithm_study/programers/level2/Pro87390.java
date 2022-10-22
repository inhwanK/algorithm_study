package algorithm_study.programers.level2;

import java.util.ArrayList;
import java.util.List;

// n^2 배열 자르기 - https://school.programmers.co.kr/learn/courses/30/lessons/87390
public class Pro87390 {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left);
        int[] answer = new int[size + 1];

        int istart = (int) (left / n);
        int jstart = (int) (left % n);
        int index = 0;
        for (int i = istart; i < n; i++) {
            for (int j = jstart; j < n; j++) {
                if (index > size) {
                    break;
                }
                answer[index] = i > j ? i + 1 : j + 1;
                index++;
            }
            jstart = 0;
            if (index > size) {
                break;
            }
        }

        return answer;
    }

    public int[] solution_answer(int n, long left, long right) {
        List<Integer> ansList = new ArrayList<>();
        int leftInt = (int) left;
        int rightInt = (int) right;

        for (long i = left; i <= right; i++) {
            if (i / n <= i % n)
                ansList.add((int) (i % n) + 1);
            else
                ansList.add((int) (i / n) + 1);
        }

        int[] answer = new int[ansList.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = ansList.get(i);

        return answer;
    }
}
