package algorithm_study.programers.level2;

import java.util.*;

// 기능개발 - https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class Pro42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList();
        int sum = 0;
        while (sum < speeds.length) {

            for (int i = sum; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[sum] >= 100) {
                int count = 0;
                for (int i = sum; i < progresses.length; i++) {
                    if (progresses[i] >= 100) {
                        count++;
                    } else {
                        break;
                    }
                }
                list.add(count);
                sum += count;
            }

        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int[] solution_answer(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
    }

    public int[] solution_answer2(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
