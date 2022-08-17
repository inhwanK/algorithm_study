package algorithm_study.boj.codeplus.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 차이를 최대로 - https://www.acmicpc.net/problem/10819
public class BOJ10819 {
    public static int n, result;
    public static int arr[], sumArr[];
    public static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        visited = new boolean[n];
        sumArr = new int[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        result = 0;
        dfs(0);
        System.out.println(result);
    }

    static void dfs(int depth) {
        if (depth == n) {
            result = Math.max(result, add());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sumArr[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int add() {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(sumArr[i] - sumArr[i + 1]);
        }
        return sum;
    }
}

// 이거 나도 시도했던 코드.... 중앙쯤에서 비교를 했어야 함..
// 하지만 보통 문제의 의도는 완전탐색을 구현할 수 있는지를 묻는 것 같은데..
// 그렇다면 대부분의 완전탐색 문제는 이런 예외케이스를 굳이 발견하지 않아도 될 듯?
// 상위 정답 - https://www.acmicpc.net/source/8923486
class BOJ10819Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(data[i]);
        Arrays.sort(arr);
        int ans = 0;
        int NN = N;
        if (N % 2 == 1) {
            NN--;
            ans = Math.max(arr[N / 2] - arr[N / 2 - 1], arr[N / 2 + 1] - arr[N / 2]);
        }
        for (int i = 0; i < NN - 1; i++) {
            if (i % 2 == 0)
                ans += (arr[N - (i / 2) - 1] - arr[N / 2 - (i / 2) - 1]);
            else
                ans += (arr[N - (i / 2) - 1] - arr[N / 2 - (i / 2) - 2]);
        }
        System.out.println(ans);
    }
}