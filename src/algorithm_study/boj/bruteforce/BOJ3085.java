package algorithm_study.boj.bruteforce;

import java.io.*;

// 사탕 게임 - https://www.acmicpc.net/problem/3085
public class BOJ3085 {
    public static char[][] board = new char[51][51];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int max = countMaxValue();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                        continue;

                    if (board[i][j] != board[nx][ny]) {
                        swap(i, j, nx, ny);
                        max = Math.max(max, countMaxValue());
                        swap(i, j, nx, ny);

                    }
                }
            }
        }
        System.out.println(max);
    }

    public static int countMaxValue() {
        int max = 1;
        for (int i = 0; i < n; i++) {
            int xTemp = 1;
            int yTemp = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    xTemp++;
                    max = Math.max(max, xTemp);
                } else {
                    xTemp = 1;
                }

                if (board[j][i] == board[j + 1][i]) {
                    yTemp++;
                    max = Math.max(max, yTemp);
                } else {
                    yTemp = 1;
                }
            }
        }
        return max;
    }

    public static void swap(int i, int j, int dx, int dy) {
        char temp = board[i][j];
        board[i][j] = board[dx][dy];
        board[dx][dy] = temp;
    }
}

// 상위 정답 - https://www.acmicpc.net/source/34603759
class BOJ3085Answer {
    public static char[][] candy;
    public static boolean[][] checked;
    public static int ans, n, dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        candy = new char[n][n];
        for (int i=0; i<n; i++) {
            candy[i] = br.readLine().toCharArray();
        }

        ans = 0;
        checked = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                check(i, j);
                for (int k=0; k<4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];

                    if (nx < 0 || n <= nx || ny < 0 || n <= ny) continue;	// 범위 넘어가면 체크 X
                    if (!checked[nx][ny] && candy[i][j] != candy[nx][ny]) {
                        // 체크하지 않은 곳이고, 캔디 색상이 다를 때만 체크
                        swap(i, j, nx, ny);
                        check(i, j);
                        check(nx, ny);
                        swap(i, j, nx, ny);
                    }
                }
                // 4방향 모두 고려했다면 방문 체크
                checked[i][j] = true;
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }

    private static void check(int x, int y) {
        int rowcnt = 1, colcnt = 1;
        char target = candy[x][y];
        // 같은 행 + 가장 긴 연속 부분의 수
        for (int col = y-1; col >= 0; col--) {
            if (candy[x][col] != target) break;
            rowcnt++;
        }
        for (int col = y+1; col < n; col++) {
            if (candy[x][col] != target) break;
            rowcnt++;
        }

        ans = Math.max(rowcnt, ans);
        // 같은 열 + 가장 긴 연속 부분의 수

        for (int row = x-1; row >= 0; row--) {
            if (candy[row][y] != target) break;
            colcnt++;
        }
        for (int row = x+1; row < n; row++) {
            if (candy[row][y] != target) break;
            colcnt++;
        }
        ans = Math.max(colcnt, ans);
    }

    private static void swap(int x, int y, int nx, int ny) {
        char temp = candy[x][y];
        candy[x][y] = candy[nx][ny];
        candy[nx][ny] = temp;
    }
}