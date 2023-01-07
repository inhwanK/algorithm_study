package algorithm_study.programers.level2;

import java.util.*;

// 메뉴 리뉴얼 - https://school.programmers.co.kr/learn/courses/30/lessons/72411
public class Pro72411 {
    HashMap<String, Integer> map = new HashMap();

    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }


        List<String> answerList = new ArrayList();

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                dfs(course[i], "", orders[j]);
            }

            if (map.isEmpty()) {
                continue;
            }

            List<Integer> list = new ArrayList(map.values());
            int max = Collections.max(list);

            if (max < 2) {
                continue;
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    answerList.add(key);
                    System.out.println(key);
                }
            }

            map.clear();
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }

    private void dfs(int depth, String now, String other) {
        if (depth == 0) {

            map.put(now, map.getOrDefault(now, 0) + 1);
            return;
        }

        for (int i = 0; i < other.length(); i++) {
            dfs(depth - 1, now + other.charAt(i), other.substring(i + 1));
        }
    }
}
