package algorithm_study.boj.bruteforce.nm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5) - https://www.acmicpc.net/problem/15654
public class BOJ15654 {
    public static int n, m;
    public static boolean[] visited;
    public static String[] answer;
    public static int[] arr;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        visited = new boolean[n];
        answer = new String[m * 2];
        sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            answer[i * 2 + 1] = " ";
        }
        answer[m * 2 - 1] = "\n";


        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        permutation(0);
        System.out.println(sb);
    }

    public static void permutation(int depth) {

        if (depth == m) {
            for (int i = 0; i < m * 2; i++) {
                sb.append(answer[i]);
            }
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth * 2] = arr[i] + "";
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}

// 내 풀이와 큰 차이 없음, 불필요한 문자열이 없는 정도?
// 1위 정답 - https://www.acmicpc.net/source/12954069
class BOJ15654Answer {
    private static int n, m;
    private static int seq[];
    private static int num[];
    private static boolean visited[];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        num = new int[n];
        visited = new boolean[n];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        solution(0);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void solution(int len) {
        if (len == m) {
            for (int i = 0; i < m; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            seq[len] = num[i];
            solution(len + 1);
            visited[i] = false;
        }
    }
}