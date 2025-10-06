package algorithm_study.programers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 경주로 건설 - https://school.programmers.co.kr/learn/courses/30/lessons/67259
public class Pro67259 {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int size = board.length;

        int[][][] costs = new int[size][size][4];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }


        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        heap.add(new Node(0, 0, -1, 0));

        while (!heap.isEmpty()) {
            Node now = heap.poll();

            if (now.x == size - 1 && now.y == size - 1) {
                answer = Math.min(answer, now.cost);
                continue;
            }

            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for (int dir = 0; dir < 4; dir++) {

                int nx = dx[dir] + now.x;
                int ny = dy[dir] + now.y;

                if (nx < 0 || nx >= size || ny < 0 || ny >= size || board[nx][ny] == 1) {
                    continue;
                }

                int plus = 0;
                if (dir == now.dir || now.dir == -1) {
                    plus = 100;
                } else {
                    plus = 600;
                }

                if (now.cost + plus <= costs[nx][ny][dir]) {
                    heap.add(new Node(nx, ny, dir, now.cost + plus));
                    costs[nx][ny][dir] = now.cost + plus;
                }
            }
        }

        return answer;
    }
}

class Node {
    int x;
    int y;
    int dir;
    int cost;

    public Node(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}