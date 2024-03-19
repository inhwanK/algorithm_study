package algorithm_study.programers.level2;

import java.util.*;

// 우박수열 정적분 - https://school.programmers.co.kr/learn/courses/30/lessons/134239
public class Pro134239 {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        // 그래프 그리기
        ArrayList<Double> target = new ArrayList();
        lothar(0, k, target);
        int n = target.size() - 1;
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = target.size() - 1 + ranges[i][1];

            if (start > end) {
                answer[i] = -1;
                continue;
            }

            double sum = 0;
            for (int j = start; j < end; j++) {
                double left = target.get(j);
                double right = target.get(j + 1);

                double surp = (left + right) / 2;
                sum += surp;
            }
            answer[i] = sum;
        }

        return answer;
    }

    private void lothar(int count, int k, ArrayList<Double> lothar) {
        lothar.add((double) k);
        if (k <= 1) {
            return;
        }

        if (k % 2 == 0) {
            lothar(count + 1, k / 2, lothar);
        } else {
            lothar(count + 1, k * 3 + 1, lothar);
        }
    }
}
