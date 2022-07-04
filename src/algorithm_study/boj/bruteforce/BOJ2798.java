package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 블랙잭 - https://www.acmicpc.net/problem/2798
public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        String[] numbers = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = num[i] + num[j] + num[k];
                    if (temp <= m) max = Math.max(temp, max);
                }
            }
        }

        System.out.println(max);
    }
}

// 카드 한번 고를 때 마다 m을 넘지 않는지 체크하여 반복문을 덜 돌게끔 함
// 1위 정답 - https://www.acmicpc.net/source/34732549
class BOJ2798Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(token.nextToken()); // 카드의 개수
        int M = Integer.parseInt(token.nextToken()); // 조건
        int[] arr = new int[N];

        token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        br.close();

        int answer = search(arr, N, M);

        System.out.println(answer);
    }

    private static int search(int[] arr, int N, int M) {
        int answer = 0;
        for (int i = 0; i < N - 2; i++) { // 3개를 고르기 때문에 첫번째 카드는 N-2 까지

            if (arr[i] > M) continue; // 첫 번째 카드가 M보다 크면 건너뛴다.
            for (int j = i + 1; j < N - 1; j++) { // 두번째 카드는 N-1 까지

                if (arr[i] + arr[j] > M) continue; // 두 카드의 합이 M보다 크면 건너뛴다.
                for (int k = j + 1; k < N; k++) { // 세번째 카드는 N까지

                    int temp = arr[i] + arr[j] + arr[k];
                    if (M == temp) { // M과 세 카드의 합이 같은지 확인
                        return temp;
                    }
                    if (answer < temp && temp < M) { // 세 카드의 합이 이전 합보다 크면서 M보다 작을 경우 갱신
                        answer = temp;
                    }
                }
            }
        }
        // 순회를 마치면 리턴
        return answer;
    }

}