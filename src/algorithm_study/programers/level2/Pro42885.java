package algorithm_study.programers.level2;

import java.util.*;

// 구명보트 - https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Pro42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int index = 0;
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                answer++;
                index++;
            } else {
                answer++;
            }
        }

        return answer;
    }

    public int solution_answer(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
