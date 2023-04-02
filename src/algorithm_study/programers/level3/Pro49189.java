package algorithm_study.programers.level3;

import java.util.*;

// 가장 먼 노드 - https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class Pro49189 {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        Queue<Integer> que = new LinkedList();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();

        for (int i = 0; i < edge.length; i++) {
            map.put(edge[i][0], map.getOrDefault(edge[i][0], new ArrayList()));
            map.put(edge[i][1], map.getOrDefault(edge[i][1], new ArrayList()));

            set.add(edge[i][0]);
            set.add(edge[i][1]);

            if (!map.get(edge[i][0]).contains(edge[i][1])) {
                map.get(edge[i][0]).add(edge[i][1]);
            }

            if (!map.get(edge[i][1]).contains(edge[i][0])) {
                map.get(edge[i][1]).add(edge[i][0]);
            }
        }

        boolean[] visited = new boolean[n + 1];
        que.add(1);
        visited[1] = true;

        answer = 1;
        Queue<Integer> temp = new LinkedList();

        while (!que.isEmpty()) {
            int target = que.poll();
            ArrayList<Integer> nextList = map.get(target);

            for (int i = 0; i < nextList.size(); i++) {
                if (!visited[nextList.get(i)]) {
                    temp.add(nextList.get(i));
                    visited[nextList.get(i)] = true;
                }
            }

            if (que.isEmpty() && !temp.isEmpty()) {
                answer = temp.size();
                while (!temp.isEmpty()) {
                    que.add(temp.poll());
                }
            }
        }

        return answer;
    }
}
