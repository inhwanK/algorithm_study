package algorithm_study.programers.level2;

import java.util.*;

// 구명보트 - https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class Pro42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            sum += people[i];
            count++;
            if (sum > limit) {
                sum = people[i];
                answer++;
                count = 1;
            }

            if (count == 2) {
                sum = 0;
                count = 0;
                answer++;
            }
        }

        if (sum > 0) {
            answer++;
        }
        return answer;
    }
}
