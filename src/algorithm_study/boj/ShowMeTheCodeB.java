package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 도넛 행성
public class ShowMeTheCodeB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] check = new boolean[n][m];
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] now = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(now[j]) == 0) {
                    check[i][j] = true;
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!check[i][j]) {
                    continue;
                }

                Queue<int[]> que = new LinkedList<>();
                int[] target = {i, j};
                check[i][j] = true;
                que.add(target);

                while (!que.isEmpty()) {
                    int[] now = que.poll();

                    for (int dir = 0; dir < 4; dir++) {
                        int x = now[0] + dx[dir];
                        int y = now[1] + dy[dir];

                        if (x < 0) {
                            x = n - 1;
                        }
                        if (y < 0) {
                            y = m - 1;
                        }
                        if (x >= n) {
                            x = 0;
                        }
                        if (y >= m) {
                            y = 0;
                        }

                        if (check[x][y]) {
                            int[] plus = {x, y};
                            que.add(plus);
                            check[x][y] = false;
                        }
                    }
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
