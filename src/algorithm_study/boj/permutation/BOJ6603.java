package algorithm_study.boj.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 로또 - https://www.acmicpc.net/problem/6603
public class BOJ6603 {
    public static int k, arr[];
    public static int[] result = new int[6];
    public static boolean visited[];
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            permutation(0, 0);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void permutation(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}

// 내 풀이와 큰 차이 없음
// 상위 정답 - https://www.acmicpc.net/source/34501475
class BOJ6603Answer {

    static StringBuilder sb;
    static int[] numbers;
    static boolean[] isUsed;
    static int[] result;
    static int k;

    public static void main(String[] args) throws IOException {

        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            numbers = new int[k];
            isUsed = new boolean[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            func(0);
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static void func(int n) {
        if (n == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < k; i++) {

            if (!isUsed[i]) {
                if (n > 0 && result[n - 1] > numbers[i]) continue;
                isUsed[i] = true;
                result[n] = numbers[i];
                func(n + 1);
                isUsed[i] = false;
            }
        }
    }
}