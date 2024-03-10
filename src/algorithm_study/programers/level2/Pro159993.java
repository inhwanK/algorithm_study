package algorithm_study.programers.level2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// 미로탈출 - https://school.programmers.co.kr/learn/courses/30/lessons/159993
public class Pro159993 {
    public int solution(String[] maps) {
        int answer = 0;

        int xSize = maps.length;
        int ySize = maps[0].length();

        int[][] loc = new int[3][2];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char target = maps[i].charAt(j);
                if (target == 'S') {
                    loc[0] = new int[]{i, j};
                }

                if (target == 'L') {
                    loc[1] = new int[]{i, j};
                }

                if (target == 'E') {
                    loc[2] = new int[]{i, j};
                }
            }
        }

        int[][] board = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[xSize][ySize];
        if (bfs(board, maps.length, maps[0].length(), loc[0], loc[1], visited, maps) == -1) {
            return -1;
        }
        visited = new boolean[xSize][ySize];
        return bfs(board, maps.length, maps[0].length(), loc[1], loc[2], visited, maps);
    }

    private int bfs(int[][] board, int xSize, int ySize, int[] start, int[] end, boolean[][] visited, String[] maps) {
        visited[start[0]][start[1]] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> heap = new LinkedList();
        heap.add(start);
        while (!heap.isEmpty()) {
            int[] now = heap.poll();
            if (now[0] == end[0] && now[1] == end[1]) {
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];

                if (nx < 0 || nx >= xSize || ny < 0 || ny >= ySize ||
                        visited[nx][ny]) {
                    continue;
                }

                if (maps[nx].charAt(ny) == 'X') {
                    continue;
                }

                board[nx][ny] = board[now[0]][now[1]] + 1;
                visited[nx][ny] = true;

                heap.add(new int[]{nx, ny});
            }
        }

        if (!visited[end[0]][end[1]]) {
            return -1;
        }

        return board[end[0]][end[1]];
    }


    // 레버~시작점 거리와 레버~출구 거리의 합
    public int solution2(String[] maps) {


        int R = maps.length;
        int C = maps[0].length();
        int[][] time = new int[R][C];
        Queue<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (maps[r].charAt(c) == 'L') {
                    q.add(r);
                    q.add(c);
                } else {
                    time[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        int toStart = -1;
        int toEnd = -1;

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (toStart == -1 || toEnd == -1) {
            if (q.size() == 0) return -1;
            int r = q.poll();
            int c = q.poll();
            int t = time[r][c] + 1;
            for (int i = 0; i < 4; i++) {
                int nextR = r + dir[i][0];
                int nextC = c + dir[i][1];
                if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C) {
                    if (maps[nextR].charAt(nextC) != 'X' && time[nextR][nextC] > t) {
                        time[nextR][nextC] = t;
                        q.add(nextR);
                        q.add(nextC);
                        if (maps[nextR].charAt(nextC) == 'S' && toStart == -1) {
                            toStart = t;
                        }
                        if (maps[nextR].charAt(nextC) == 'E' && toEnd == -1) {
                            toEnd = t;
                        }
                    }
                }
            }
        }

        return toStart + toEnd;
    }
}
