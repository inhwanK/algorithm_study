package algorithm_study.boj.codeplus.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이전 순열 - https://www.acmicpc.net/problem/10973
public class BOJ10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            System.out.println(-1);
            return;
        }

        for (int i = n - 1; i > index; i--) {
            if (arr[i] < arr[index]) {
                int swap = arr[i];
                arr[i] = arr[index];
                arr[index] = swap;
                break;
            }
        }
        // 이미 오름차순으로 정렬된 부분을 영역으로 잡았기 때문에
        // 단순히 배열을 뒤집으면 됨
        int left = index + 1;
        int right = n - 1;

        while (left < right) {
            int swap = arr[left];
            arr[left] = arr[right];
            arr[right] = swap;

            left++;
            right--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// 내 풀이와 큰 차이없음 swap 함수를 구현한 것 정도?
// 1위 정답 - https://www.acmicpc.net/source/9467579
class BOJ10973Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index = -1;
        for (int i = N - 1; i > 0; i--) { // 뒤에서부터 보면서 이전 수 > 다음 수인 다음 수의 인덱스를 찾는다.
            if (A[i - 1] > A[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) { // 만약 이전 수 > 다음 수가 없다면, 오름차순이므로 다음 순열이 없고 -1 출력.
            System.out.println(-1);
            return;
        }
        for (int i = N - 1; i >= index; i--) { // 맨 뒤에서 인덱스까지
            if (A[i] < A[index - 1]) { // 처음으로 인덱스 -1의 위치의 수보다 작은 수가 나올 경우
                swap(A, i, index - 1); // 그 수와 위치를 바꿈.
                break;
            }
        }
        for (int i = index; i < N; i++) { // 인덱스부터 내림차순으로 정렬함.
            for (int j = index; j < N - 1; j++) {
                if (A[j] < A[j + 1]) {
                    swap(A, j, j + 1);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(' ');
        }
        System.out.println(sb.toString());
    }

    public static void swap(int[] A, int a, int b) {
        int temp;
        temp = A[a];
        A[a] = A[b];
        A[b] = temp;
        return;
    }
}