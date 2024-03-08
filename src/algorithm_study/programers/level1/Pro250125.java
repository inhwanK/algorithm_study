package algorithm_study.programers.level1;

// [PCCE 기출문제] 9번 / 이웃한 칸 - https://school.programmers.co.kr/learn/courses/30/lessons/250125
public class Pro250125 {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dh = {0, 1, 0, -1};
        int[] dw = {1, 0, -1, 0};

        String color = board[h][w];

        for (int dir = 0; dir < 4; dir++) {
            int nh = h + dh[dir];
            int nw = w + dw[dir];

            if (nw < 0 || nh < 0 || nw >= board.length || nh >= board.length) {
                continue;
            }

            if (board[h][w].equals(board[nh][nw])) {
                answer++;
            }
        }

        return answer;
    }
}
