package algorithm_study.programers.level3;

import java.util.*;

// 보석 쇼핑 - https://school.programmers.co.kr/learn/courses/30/lessons/67258
public class Pro67258 {
    public int[] solution(String[] gems) {
        int kind = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];
        int length = Integer.MAX_VALUE, L = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int R = 0; R < gems.length; R++) {
            map.put(gems[R], map.getOrDefault(gems[R], 0) + 1);

            while (map.get(gems[L]) > 1) {
                map.put(gems[L], map.get(gems[L]) - 1);
                L++;
            }

            if (map.size() == kind && length > (R - L)) {
                length = R - L;
                answer[0] = L + 1;
                answer[1] = R + 1;
            }
        }

        return answer;
    }

    public int[] solution_answer1(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1; answer[1] = gems.length;

        HashMap<String, Integer> map = new HashMap<>(); // 보석 종류 구별
        int idx = 0;

        for(String j : gems) {
            if(!map.containsKey(j)) map.put(j, idx++);
        }

        int kind = map.size();
        int[] count = new int[kind]; // 해당 구간의 보석 개수 기록

        int s = 0; int e = 0;
        int cnt = 0;

        while (e < gems.length) {
            if(cnt < kind) {
                int num = ++count[map.get(gems[e])];

                if(num == 1) cnt++;
                e++;
            }
            else {
                int num = --count[map.get(gems[s])];

                if(num == 0) cnt--;

                // 구간이 더 짧고 ( 구간 길이 같은 경우 시작 번호 더 짧은 것)
                if(answer[1] - answer[0] > e - (s+1)) {
                    answer[0] = s+1;
                    answer[1] = e;
                }
                s++;
            }
        }
        return answer;
    }
}
