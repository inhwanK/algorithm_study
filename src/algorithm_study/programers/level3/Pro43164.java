package algorithm_study.programers.level3;

import java.util.*;

// 여행경로 - https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Pro43164 {
    List<String> list;

    public String[] solution(String[][] tickets) {

        boolean[] visited = new boolean[tickets.length];
        list = new ArrayList();
        dfs(0, "ICN", "ICN", visited, tickets);

        Collections.sort(list);
        String preAns = list.get(0);
        String[] answer = preAns.split(" ");
        return answer;
    }

    public void dfs(int depth, String arrive, String route, boolean[] visited, String[][] tickets) {
        if (depth == tickets.length) {
            list.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (!tickets[i][0].equals(arrive)) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, tickets[i][1], route + " " + tickets[i][1], visited, tickets);
            visited[i] = false;
        }
    }
}
