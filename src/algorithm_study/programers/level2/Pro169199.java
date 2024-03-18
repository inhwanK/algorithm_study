package algorithm_study.programers.level2;

import java.util.*;

// 리코쳇 로봇 - https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class Pro169199 {
    public int solution(String[] board) {
        int answer = 0;

        char[][] target = new char[board.length][board[0].length()];

        int gx = 0;
        int gy = 0;
        int[] start = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                target[i][j] = board[i].charAt(j);
                if (target[i][j] == 'G') {
                    gx = i;
                    gy = j;
                    continue;
                }

                if (target[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }

            }
        }

        boolean[][] visited = new boolean[board.length][board[0].length()];
        answer = slide(gx, gy, start, target, visited);

        return answer;
    }

    private int slide(int gx, int gy, int[] start, char[][] target, boolean[][] visited) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<Point> que = new LinkedList();
        que.add(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();
            int x = now.x;
            int y = now.y;

            if (x == gx && y == gy) {
                return now.count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x;
                int ny = y;

                boolean move = false;

                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];

                    if (nx < 0 || nx >= target.length || ny < 0 || ny >= target[0].length ||
                            target[nx][ny] == 'D') {
                        if (visited[nx - dx[dir]][ny - dy[dir]]) {
                            break;
                        }

                        if (move) {
                            que.add(new Point(nx - dx[dir], ny - dy[dir], now.count + 1));
                            visited[nx - dx[dir]][ny - dy[dir]] = true;
                            move = false;
                        }

                        break;
                    }

                    move = true;
                }
            }
        }


        return -1;
    }

    class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


    // ----------------------------------------- 정답 풀이
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    private final char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';

    private int n, m;

    private class Moving {
        int x, y, depth;

        public Moving(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution2(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();

        Moving robot = null;
        Moving goal = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = board[i].charAt(j);

                if (ch == ROBOT) {
                    robot = new Moving(i, j, 0);
                } else if (ch == GOAL) {
                    goal = new Moving(i, j, 0);
                }
            }
        }

        answer = bfs(board, robot, goal);

        return answer;
    }

    private int bfs(String[] board, Moving robot, Moving goal) {
        Queue<Moving> qu = new LinkedList<>();
        qu.add(robot);
        boolean[][] visited = new boolean[n][m];
        visited[robot.x][robot.y] = true;

        while (!qu.isEmpty()) {
            Moving cn = qu.poll();

            if (cn.x == goal.x && cn.y == goal.y) {
                return cn.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cn.x;
                int ny = cn.y;

                // 범위를 벗어나거나 장애물을 만날 때 까지 반복
                while (inRange(nx, ny) && board[nx].charAt(ny) != DISABLE) {
                    nx += dx[i];
                    ny += dy[i];
                }

                // 범위를 벗어나거나 장애물 만나기 '직전'의 상태
                nx -= dx[i];
                ny -= dy[i];

                // 방문을 하거나 같은 위치일 경우 스킵
                if (visited[nx][ny] || (cn.x == nx && cn.y == ny)) continue;

                visited[nx][ny] = true;
                qu.add(new Moving(nx, ny, cn.depth + 1));
            }
        }

        return -1;
    }

    private boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
