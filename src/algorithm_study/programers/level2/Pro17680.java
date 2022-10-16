package algorithm_study.programers.level2;

import java.util.LinkedList;

// [1차] 캐시 - https://school.programmers.co.kr/learn/courses/30/lessons/17680
public class Pro17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toLowerCase();
            if (list.remove(s)) {
                answer++;
                list.add(s);
            } else {
                if (list.size() == cacheSize) {
                    list.remove();
                }
                answer += 5;
                list.add(s);
            }

        }

        return answer;
    }
}
