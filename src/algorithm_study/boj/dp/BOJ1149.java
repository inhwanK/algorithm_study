package algorithm_study.boj.dp;

import java.io.*;
import java.util.StringTokenizer;

// RGB거리 - https://www.acmicpc.net/problem/1149
public class BOJ1149 {
    static int n, result, arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][3];

        String[] first = br.readLine().split(" ");
        arr[1][0] = Integer.parseInt(first[0]);
        arr[1][1] = Integer.parseInt(first[1]);
        arr[1][2] = Integer.parseInt(first[2]);

        for (int i = 2; i <= n; i++) {
            String[] cost = br.readLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int now = Integer.parseInt(cost[j]);
                switch (j) {
                    case 0: {
                        arr[i][j] = Math.min(arr[i - 1][1], arr[i - 1][2]) + now;
                        break;
                    }

                    case 1: {
                        arr[i][j] = Math.min(arr[i - 1][0], arr[i - 1][2]) + now;
                        break;
                    }
                    case 2: {
                        arr[i][j] = Math.min(arr[i - 1][0], arr[i - 1][1]) + now;
                        break;
                    }
                }
            }
        }

        result = Math.min(arr[n][0], Math.min(arr[n][1], arr[n][2]));
        System.out.println(result);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/41888566
class BOJ1149Answer {
    static int[][] cost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        cost = new int[cnt][3];

        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < cnt; i++) {
            cost[i][0] += Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        bw.write(Integer.toString(Math.min(Math.min(cost[cnt - 1][0], cost[cnt - 1][1]), cost[cnt - 1][2])));
        bw.flush();
        bw.close();
        br.close();
    }
}