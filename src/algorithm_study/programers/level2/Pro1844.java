package algorithm_study.programers.level2;

import java.util.*;

// 게임 맵 최단거리 - https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Pro1844 {
    class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;

        // visited 초기화
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};

        Queue<Node> q = new LinkedList();
        Node node = new Node(0, 0, 1);
        visited[0][0] = true;
        q.add(node);

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {
                answer = now.count;
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!validateComponent(nx, ny, maps)) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }

                if (maps[nx][ny] == 0) {
                    continue;
                }

                q.add(new Node(nx, ny, now.count + 1));
                visited[nx][ny] = true;
            }
        }

        return answer;
    }

    public boolean validateComponent(int x, int y, int[][] maps) {
        if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) {
            return false;
        }

        return true;
    }
}
