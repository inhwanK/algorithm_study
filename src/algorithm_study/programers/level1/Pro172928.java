package algorithm_study.programers.level1;

public class Pro172928 {
    // 방향 매핑: N, S, W, E
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[] dir = {"N", "S", "W", "E"};

    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();
        char[][] board = new char[h][w];

        int x = 0, y = 0; // 시작 위치
        for (int i = 0; i < h; i++) {
            board[i] = park[i].toCharArray();
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        for (String r : routes) {
            String[] split = r.split(" ");
            String op = split[0];
            int n = Integer.parseInt(split[1]);

            int dirIdx = -1;
            for (int i = 0; i < 4; i++) {
                if (dir[i].equals(op)) dirIdx = i;
            }

            int nx = x, ny = y;
            boolean valid = true;

            for (int i = 1; i <= n; i++) {
                int tx = x + dx[dirIdx] * i;
                int ty = y + dy[dirIdx] * i;

                if (tx < 0 || ty < 0 || tx >= h || ty >= w || board[tx][ty] == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                x += dx[dirIdx] * n;
                y += dy[dirIdx] * n;
            }
        }

        return new int[]{x, y};
    }
}
