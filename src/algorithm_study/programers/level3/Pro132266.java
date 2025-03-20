package algorithm_study.programers.level3;

import java.util.*;

public class Pro132266 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        Queue<Integer> que = new LinkedList();
        que.add(destination);
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[destination] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                if (distance[next] != -1) {
                    continue;
                }
                distance[next] = distance[now] + 1;
                que.add(next);
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }


        return answer;
    }
}
