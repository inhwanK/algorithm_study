package algorithm_study.boj.codeplus.recursion;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 링크와 스타트 - https://www.acmicpc.net/problem/15661
public class BOJ15661 {
    static int n, result = Integer.MAX_VALUE, board[][];
    static boolean[] persons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        persons = new boolean[n + 1];
        for (int i = 2; i <= n / 2; i++) {
            splitTeam(0, i, 1);
        }
        System.out.println(result);
    }

    static void splitTeam(int depth, int m, int first) {
        if (depth == m) {
            result = Math.min(result, calculateScore());
            return;
        }

        for (int i = first; i <= n; i++) {
            persons[i] = true;
            splitTeam(depth + 1, m, i + 1);
            persons[i] = false;
        }
    }

    static int calculateScore() {
        int link = 0;
        int start = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (persons[i] && persons[j]) {
                    start += board[i - 1][j - 1] + board[j - 1][i - 1];
                }
                if (!persons[i] && !persons[j]) {
                    link += board[i - 1][j - 1] + board[j - 1][i - 1];
                }
            }
        }

        return Math.abs(start - link);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/18406506
class BOJ15661Answer_1 {
    static int n;
    static int[][] score;

    public static void main(String args[]) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(bf.readLine());
        score = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String str = bf.readLine();
            StringTokenizer tk = new StringTokenizer(str);
            for (int j = 1; j <= n; j++) {
                score[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        int max = 1 << n;
        int[] arr = new int[max];
        int min = n * n * 200;

        arr[0] = 0;
        arr[max - 1] = 0;

        for (int i = 1; i < max - 1; i++) {
            int k = -1;
            for (int j = 0; j < n; j++) {
                if (k == -1) {
                    int p = (1 << j) & i;
                    if (p != 0) {
                        k = j + 1;
                        arr[i] = arr[i & (~p)];
                    }
                } else {
                    int p = (1 << j) & i;
                    if (p != 0) {
                        arr[i] += score[j + 1][k];
                        arr[i] += score[k][j + 1];
                    }
                }
            }
        }

        for (int j = 1; j < (max / 2); j++) {
            int m = Math.abs(arr[j] - arr[max - 1 - j]);
            if (min > m) min = m;
        }

        bw.write("" + min);
        bw.flush();
        bw.close();
    }
}

// 상위 정답 - https://www.acmicpc.net/source/11923539
class BOJ15661Answer_2 {
    static int n;
    static int[][] feild;
    static int[] power;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        power = new int[(1 << n) - 1];
        feild = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = scan.nextInt();
                // 능력치의 합을 보여주기 위한 단계
                feild[i][j] += v;
                feild[j][i] += v;
            }
        }
        // 대각선 반쪽만 돌도록 구성
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                power[(1 << i) | (1 << j)] = feild[i][j];
            }
        }
        int chae = 1;
        for (int i = 1; i < power.length; i++) {
            if (i == chae) {
                chae = (chae << 1);
                continue;
            }
            if (power[i] != 0) continue;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    power[i] = power[i - (1 << j)];
                    int target = 1 << j;
                    for (j++; j < n; j++) {
                        if ((i & (1 << j)) != 0) {
                            power[i] += power[target | 1 << j];
                        }
                    }
                }
            }
        }
        int result = 9999999;
        int full_bit = (1 << n) - 1; //n이 3이면 111 이 됨.
        for (int i = 1; i < power.length / 2; i++) {
            int s_r = Math.abs(power[i] - power[full_bit ^ i]);
            result = result < s_r ? result : s_r;
        }
        System.out.println(result);
    }
}