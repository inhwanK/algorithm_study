package algorithm_study.boj.recursion;

import java.io.*;

// 분할과 정복 알고리즘?
// 별 찍기 - 10 - https://www.acmicpc.net/problem/2447
public class BOJ2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void star(int x, int y, int N, boolean blank) {

        // 공백칸일 경우
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더이상 쪼갤 수 없는 블록일 때
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

		/*
		   N=27 일 경우 한 블록의 사이즈는 9이고,
		   N=9 일 경우 한 블록의 사이즈는 3이듯
		   해당 블록의 한 칸을 담을 변수를 의미 size

		   count는 별 출력 누적을 의미
		 */

        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) { // 공백 칸일 경우
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}

// 위 풀이랑 동일한 알고리즘
// 상위 정답 - https://www.acmicpc.net/source/43051500
class BOJ2447Answer {
    public static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        star = new char[n][n];

        printStar(0, 0, n, true);
        for (int i = 0; i < n; i++) {
            bw.write(star[i]);
            bw.write("\n");
        }
        bw.flush();
    }

    private static void printStar(int x, int y, int n, boolean isStar) {
        if (!isStar) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    star[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            star[x][y] = '*';
            return;
        }
        int cnt = 0;
        for (int i = x; i < x + n; i += n / 3) {
            for (int j = y; j < y + n; j += n / 3) {
                printStar(i, j, n / 3, cnt != 4);
                cnt++;
            }
        }
    }
}