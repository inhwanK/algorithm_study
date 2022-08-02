package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호 만들기 - https://www.acmicpc.net/problem/1759
public class BOJ1759 {
    public static int l, c;
    public static char[] arr, result;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        result = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        createPassword(0, 0);
        System.out.println(sb);
    }

    public static void createPassword(int depth, int start) {
        if (depth == l) {
            if (!validCheck(result)) return;

            for (int i = 0; i < l; i++) {
                sb.append(result[i]);
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < c; i++) {
            result[depth] = arr[i];
            createPassword(depth + 1, i + 1);
        }
    }

    public static boolean validCheck(char[] result) {
        int count = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 'a') {
                count++;
                continue;
            }
            if (result[i] == 'e') {
                count++;
                continue;
            }
            if (result[i] == 'i') {
                count++;
                continue;
            }
            if (result[i] == 'o') {
                count++;
                continue;
            }
            if (result[i] == 'u') {
                count++;
                continue;
            }
        }

        if (count >= 1 && result.length - count >= 2) {
            return true;
        }
        return false;
    }
}

// 모음 자음 정보를 따로 넣음... int, byte 연결시킬 수 있어야 함.
// 상위 정답 - https://www.acmicpc.net/source/36201184
class BOJ1759Answer {
    static int N, M;
    static char[] A;

    static char[] answer;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        A = new char[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            A[i] = st.nextToken().charAt(0);

        Arrays.sort(A);

        answer = new char[M + 1];
        answer[M] = '\n';

        check = new boolean[123];
        check['a'] = check['e'] = check['i'] = check['o'] = check['u'] = true;

        dfs(-1, 0, 0, 0);

        System.out.println(sb);
    }

    static void dfs(int n, int m, int mo, int za) {
        if (m == M) {
            if (mo >= 1 && za >= 2)
                sb.append(answer);

            return;
        }

        for (int i = n + 1; i <= N - M + m; i++) {
            answer[m] = A[i];
            dfs(i, m + 1, mo + (check[A[i]] ? 1 : 0), za + (check[A[i]] ? 0 : 1));
        }
    }
}