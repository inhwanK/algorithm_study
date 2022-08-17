package algorithm_study.boj.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 체스판 다시 칠하기 - https://www.acmicpc.net/problem/1018
public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        // 뒤죽박죽 보드 초기화
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // W가 시작인 체스판과 B가 시작인 체스판을 따로 저장
        char[][] chess = new char[8][8];
        char[][] ssehc = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    chess[i][j] = 'W';
                    ssehc[i][j] = 'B';
                } else {
                    chess[i][j] = 'B';
                    ssehc[i][j] = 'W';
                }
            }
        }

        int min = 64;
        // 필터링 시작할 인덱스 설정
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {

                int whiteCount = 0;
                int blackCount = 0;

                // 시작 인덱스에 따라 비교
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if (board[x][y] != chess[x - i][y - j]) whiteCount++;
                        if (board[x][y] != ssehc[x - i][y - j]) blackCount++;
                    }
                }
                // 최솟값 저장
                min = Math.min(Math.min(whiteCount, blackCount), min);
            }
        }
        System.out.println(min);
    }
}

// 다른 코드 - https://st-lab.tistory.com/101
class BOJ1018Answer_1 {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];
        // 배열 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;        // W일 때는 true
                } else {
                    arr[i][j] = false;        // B일 때는 false
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }


    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];    // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색이 아닐경우 count 1 증가
                if (arr[i][j] != TF) {
                    count++;
                }
//              다음 칸은 색이 바뀌므로 true라면 false로, false 라면 true로 값을 변경한다.
                TF = (!TF);
            }
            TF = !TF;
        }

        // 첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
        // 첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
        // 색칠 할 개수(64 - count) 중 최솟값을 count 에 저장
        count = Math.min(count, 64 - count);

        // 이전까지의 경우 중 최솟값보다 현재 count 값이
        // 더 작을 경우 최솟값을 갱신
        min = Math.min(min, count);
    }
}