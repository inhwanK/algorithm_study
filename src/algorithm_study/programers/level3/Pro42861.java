package algorithm_study.programers.level3;

import java.util.*;

// 섬 연결하기 - https://school.programmers.co.kr/learn/courses/30/lessons/42861
public class Pro42861 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            int c1 = costs[i][0];
            int c2 = costs[i][1];

            if (findParent(parent, c1) != findParent(parent, c2)) {
                answer += costs[i][2];
                union(parent, c1, c2);
            }
        }
        return answer;
    }

    private int findParent(int[] parent, int index) {
        if (parent[index] == index) {
            return index;
        }
        return findParent(parent, parent[index]);
    }

    private void union(int[] parent, int c1, int c2) {
        int p1 = findParent(parent, c1);
        int p2 = findParent(parent, c2);

        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }
}

// bfs를 활용한 풀이 방법
class Pro42861BFS {
    static class Pair implements Comparable<Pair> {
        int node;
        int weight;


        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] map = new int[n][n];
        boolean[] visited = new boolean[n];

        for (int idx = 0; idx < n; ++idx) Arrays.fill(map[idx], Integer.MAX_VALUE);

        for (int idx = 0; idx < costs.length; ++idx) {
            map[costs[idx][0]][costs[idx][1]] = costs[idx][2];
            map[costs[idx][1]][costs[idx][0]] = costs[idx][2];
        }

        answer = bfs(0, n, map, visited);

        return answer;
    }

    private static int bfs(int start, int n, int[][] map, boolean[] visited) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        visited[start] = true;
        for (int idx = 1; idx < n; ++idx) {
            if (map[start][idx] != Integer.MAX_VALUE) pq.add(new Pair(idx, map[start][idx]));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (!visited[current.node]) {
                visited[current.node] = true;
                result += current.weight;
                for (int idx = 1; idx < n; ++idx) {
                    if (map[current.node][idx] != Integer.MAX_VALUE) pq.add(new Pair(idx, map[current.node][idx]));
                }
            }
        }

        return result;
    }
}