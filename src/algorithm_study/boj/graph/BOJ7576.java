package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 토마토 - https://www.acmicpc.net/problem/7576
public class BOJ7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] box = new int[m + 1][n + 1];

        Queue<Tomato> que = new LinkedList<>();

        int count = 0;
        for (int i = 1; i <= m; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                box[i][j] = Integer.parseInt(line[j - 1]);

                if (box[i][j] == 0) {
                    count++;
                } else if (box[i][j] == 1) {
                    Tomato tomato = new Tomato(i, j, 1, 0);
                    que.add(tomato);
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }

        int answer = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!que.isEmpty()) {
            Tomato now = que.poll();

            int i = now.x;
            int j = now.y;
            int nowIndex = now.index;
            answer = nowIndex;

            for (int dir = 0; dir < 4; dir++) {
                int nx = i + dx[dir];
                int ny = j + dy[dir];

                if (nx < 1 || nx >= box.length || ny < 1 || ny >= box[0].length) {
                    continue;
                }

                if (box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    Tomato next = new Tomato(nx, ny, 1, nowIndex + 1);
                    que.add(next);
                    count--;
                }
            }
        }

        if (count > 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}

class Tomato {
    int x;
    int y;
    int state;
    int index;

    public Tomato(int x, int y, int state, int index) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.index = index;
    }

    public String toString() {
        return x + "-" + y + " : " + index;
    }
}