package algorithm_study.programers.level2;

import java.util.*;
// 연속 부분 수열 합의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/131701
public class Pro131701 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet();

        for (int i = 0; i < elements.length; i++) {
            for (int l = 1; l <= elements.length; l++) {
                int sum = 0;
                for (int index = i; index < i + l; index++) {
                    if (index < elements.length) {
                        sum += elements[index];
                        continue;
                    }
                    sum += elements[index - elements.length];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}
