package algorithm_study.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// Rotting Oranges - https://leetcode.com/problems/rotting-oranges/description/
public class Leet994 {

    public static void main(String[] args) {
        // answer 1 리턴 시, 가독성이 낮음, Node 객체 사용으로 메모리 좀 더 씀 O(n * m)
        orangesRotting(new int[][]{{0, 1}});

        // answer 2 리턴 시 가독성 개선, int[] 타입으로 시간 저장하여 메모리 아낌 O(n * m)
        orangesRotting2(new int[][]{{0, 1}});
    }
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> que = new LinkedList<>();
        int result = -1;
        int freshCount = 0;
        int rottenCount = 0;
        // grid 탐색해서 rotten orange 모두 찾기 - O(n)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.add(new Node(i, j, 0));
                    rottenCount++;
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }


        // rotten orange 기준으로 값을 바꿔나가기 - O(n)
        while (!que.isEmpty()) {
            Node now = que.poll();
            result = now.index;

            int x = now.x;
            int y = now.y;

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효성 검사
                if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }

                // fresh orange 판별
                if (grid[nx][ny] != 1) {
                    continue;
                }

                grid[nx][ny] = 2;
                que.add(new Node(nx, ny, now.index + 1));
                freshCount--;
                rottenCount++;
            }
        }

        if (rottenCount >= 0 && freshCount > 0) {
            return -1;
        }

        if (rottenCount == 0 && freshCount == 0) {
            return 0;
        }

        return result;
    }


    public static int orangesRotting2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int time = 0;

        // 초기 상태 설정: 썩은 오렌지 추가 및 신선한 오렌지 카운트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0}); // {x, y, 시간}
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // 4방향 탐색
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // BFS로 썩은 오렌지 확산
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            time = current[2]; // 현재 시간 업데이트

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 grid 내에 있고, 신선한 오렌지일 경우
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2; // 썩은 오렌지로 변경
                    queue.add(new int[]{nx, ny, time + 1});
                    freshCount--; // 신선한 오렌지 감소
                }
            }
        }

        // 신선한 오렌지가 남아 있다면 -1 반환
        return (freshCount > 0) ? -1 : time;
    }
}


class Node {
    int x;
    int y;
    int index;

    public Node(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}
