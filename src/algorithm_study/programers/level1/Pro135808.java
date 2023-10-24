package algorithm_study.programers.level1;

import java.util.*;

// 과일 장수 - https://school.programmers.co.kr/learn/courses/30/lessons/135808
public class Pro135808 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
        }

        Collections.sort(list, Collections.reverseOrder());
        for (int i = m - 1; i < list.size(); i += m) {
            answer += list.get(i) * m;
        }
        return answer;
    }
}
