package algorithm_study.programers.level2;

import java.util.HashMap;

// 할인 행사 - https://school.programmers.co.kr/learn/courses/30/lessons/131127
public class Pro131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap();

        for (int start = 0; start < discount.length; start++) {
            for (int i = 0; i < want.length; i++) {
                map.put(want[i], number[i]);
            }

            for (int i = start; i < Math.min(discount.length, start + 10); i++) {
                if (map.get(discount[i]) == null || map.get(discount[i]) == 0) {
                    continue;
                }
                map.put(discount[i], map.get(discount[i]) - 1);
            }

            if (check(map)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean check(HashMap<String, Integer> map) {
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }
}
