package algorithm_study.programers.level3;

import java.util.*;

// 블록 이동하기 - https://school.programmers.co.kr/learn/courses/30/lessons/60063
public class Pro60063 {
    public int solution(int[][] board) {
        int n = board.length;
        Queue<State> que = new LinkedList();
        boolean[][][] visited = new boolean[n][n][2];

        que.add(new State(0, 0, 0, 0));
        visited[0][0][0] = true;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int answer = 0;
        while(!que.isEmpty()) {
            State now = que.poll();

            int r = now.r;
            int c = now.c;
            int ori = now.ori;
            int time = now.time;

            // 둘 중 한 칸이라도 마지막 칸에 도달했다면, break;
            if(r == n - 1 && c == n - 1) {
                answer = time;
                break;
            }
            if(ori == 0) {
                if(r == n - 1 && c + 1 == n - 1) {
                    answer = time;
                    break;
                }
            } else {
                if(r + 1 == n - 1 && c == n - 1) {
                    answer = time;
                    break;
                }
            }

            // 상하좌우 이동
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(validCheckMove(nr, nc, ori, n, board) && !visited[nr][nc][ori]) {
                    que.add(new State(nr, nc, ori, time + 1));
                    visited[nr][nc][ori] = true;
                }
            }

            // 회전 시도
            for (State st : getRotations(r, c, ori, board)) {
                if(visited[st.r][st.c][st.ori]) {
                    continue;
                }
                visited[st.r][st.c][st.ori] = true;
                que.add(new State(st.r, st.c, st.ori, time + 1));
            }
        }
        return answer;
    }

    private boolean validCheckMove(int nr, int nc, int ori, int n, int[][] board) {
        if(ori == 0) {
            return in(nr, nc, n) && in(nr, nc + 1, n) &&
                    board[nr][nc] == 0 && board[nr][nc + 1] == 0;
        } else {
            return in(nr, nc, n) && in(nr + 1, nc, n) &&
                    board[nr][nc] == 0 && board[nr + 1][nc] == 0;
        }
    }

    private boolean in(int nr, int nc, int n) {
        if(nr < 0 || nr >= n || nc < 0 || nc >= n) {
            return false;
        }
        return true;
    }

    // 회전 가능한 상태들 반환
    private List<State> getRotations(int r, int c, int ori, int[][] board) {
        List<State> res = new ArrayList<>();
        int n = board.length;

        if (ori == 0) { // 가로 -> 세로
            // 위로 회전
            if (in(r - 1, c, n) && in(r - 1, c + 1, n)
                    && board[r - 1][c] == 0 && board[r - 1][c + 1] == 0) {
                res.add(new State(r - 1, c, 1, 0)); // 왼쪽 칸 기준
                res.add(new State(r - 1, c + 1, 1, 0)); // 오른쪽 칸 기준
            }
            // 아래로 회전
            if (in(r + 1, c, n) && in(r + 1, c + 1, n)
                    && board[r + 1][c] == 0 && board[r + 1][c + 1] == 0) {
                res.add(new State(r, c, 1, 0));
                res.add(new State(r, c + 1, 1, 0));
            }
        } else { // 세로 -> 가로
            // 왼쪽 회전
            if (in(r, c - 1, n) && in(r + 1, c - 1, n)
                    && board[r][c - 1] == 0 && board[r + 1][c - 1] == 0) {
                res.add(new State(r, c - 1, 0, 0)); // 위쪽 칸 기준
                res.add(new State(r + 1, c - 1, 0, 0)); // 아래 칸 기준
            }
            // 오른쪽 회전
            if (in(r, c + 1, n) && in(r + 1, c + 1, n)
                    && board[r][c + 1] == 0 && board[r + 1][c + 1] == 0) {
                res.add(new State(r, c, 0, 0));
                res.add(new State(r + 1, c, 0, 0));
            }
        }
        return res;
    }
}


class State {
    int r, c, ori, time;
    public State(int r, int c, int ori, int time) {
        this.r = r;
        this.c = c;
        this.ori = ori;
        this.time = time;
    }
}
