package algorithm_study.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 좌표 정렬하기 2 - https://www.acmicpc.net/problem/11651
public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            long x = Integer.parseInt(input[0]) + 100000;
            long y = Integer.parseInt(input[1]) + 100000;

            long ny = y * 1000000;
            long nx = x;
            long result = nx + ny;
            arr[i] = result;
        }

        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int ry = (int) (arr[i] / 1000000) - 100000;
            int rx = (int) (arr[i] % 1000000) - 100000;
            System.out.println(rx + " " + ry);
        }
    }
}

// 내 풀이와 큰 차이 없음
// 상위 정답 - https://www.acmicpc.net/source/24491530
class BOJ11651Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long forGreaterY = 1000000;
        long forNegativeNum = 100000;
        long xy[] = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()) + forNegativeNum;
            long y = (Long.parseLong(st.nextToken()) + forNegativeNum) * forGreaterY;
            xy[i] = x + y;
        }
        Arrays.sort(xy);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long x = xy[i] % forGreaterY - forNegativeNum;
            long y = xy[i] / forGreaterY - forNegativeNum;
            sb.append(x + " " + y + "\n");
        }
        System.out.println(sb);
    }
}