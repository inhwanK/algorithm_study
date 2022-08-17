package algorithm_study.boj.codeplus.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// NM과 K (1) - https://www.acmicpc.net/problem/18290
public class BOJ18290 {
    public static int n, m, k, result = -10001;
    public static int[][] board;
    public static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int depth, int max) {
        if (depth == k) {
            result = Math.max(result, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j] && validCheck(i, j)) {
                    check[i][j] = true;
                    dfs(depth + 1, max + board[i][j]);
                    check[i][j] = false;
                }
            }
        }
    }

    private static boolean validCheck(int x, int y) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (check[nx][ny]) return false;
        }

        return true;
    }
}

// 1위 정답 - https://www.acmicpc.net/source/19609231
class BOJ18290Answer_1 {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] arr;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // NxM 격자판
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // K 칸 선택

        arr = new int[N][M]; // 격자판

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean[][] v = new boolean[N][M];

                v[i][j] = true;

                for (int k = 0; k < dr.length; k++) {
                    if (i + dr[k] >= 0 && i + dr[k] < N && j + dc[k] >= 0 && j + dc[k] < M) {
                        v[i + dr[k]][j + dc[k]] = true;
                    }
                }

                search(arr[i][j], 1, v);
            }
        }

        System.out.println(max);
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<int[]> list;

    private static void search(int sum, int cnt, boolean[][] v) {
        if (cnt == K) {
            max = Math.max(max, sum);
            return;
        }

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && maxVal < arr[i][j]) {
                    maxVal = arr[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!v[i][j] && maxVal == arr[i][j]) {
                    v[i][j] = true;

                    list = new ArrayList<>();

                    for (int k = 0; k < dr.length; k++) {
                        if (i + dr[k] >= 0 && i + dr[k] < N && j + dc[k] >= 0 && j + dc[k] < M) {
                            if (!v[i + dr[k]][j + dc[k]]) {
                                list.add(new int[]{i + dr[k], j + dc[k]});
                            }

                            v[i + dr[k]][j + dc[k]] = true;
                        }
                    }

                    search(sum + arr[i][j], cnt + 1, v);

                    v[i][j] = false;

                    for (int[] tmp : list) {
                        v[tmp[0]][tmp[1]] = false;
                    }
                }
            }
        }
    }
}

// 2위 정답 - https://www.acmicpc.net/source/33843556
class BOJ18290Answer_2 {
    static int[][] ary = new int[10][10];
    static int N;
    static int M;
    static int K;
    static int[] dr = {0, -1, 0, 0, 1};
    static int[] dc = {0, 0, -1, 1, 0};
    static int[][] check = new int[10][10];
    static int max;

    public static int dfs(int r, int c, int id, int sum) {
        if (id == K - 1)
            return sum;

        for (int k = 0; k < 5; k++) {
            int newR = r + dr[k];
            if (newR < 0 || newR >= N)
                continue;
            int newC = c + dc[k];
            if (newC < 0 || newC >= M)
                continue;

            check[newR][newC]++;
        }

        for (int i = r; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == r && j <= c)
                    continue;

                if (check[i][j] > 0)
                    continue;

                max = Math.max(max, dfs(i, j, id + 1, sum + ary[i][j]));
            }
        }

        for (int k = 0; k < 5; k++) {
            int newR = r + dr[k];
            if (newR < 0 || newR >= N)
                continue;
            int newC = c + dc[k];
            if (newC < 0 || newC >= M)
                continue;

            check[newR][newC]--;
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Integer.MIN_VALUE;
                ans = Math.max(ans, dfs(i, j, 0, ary[i][j]));
            }
        }

        System.out.println(ans);
    }
}