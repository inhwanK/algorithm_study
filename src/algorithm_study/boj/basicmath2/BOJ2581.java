package algorithm_study.boj.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 - https://www.acmicpc.net/problem/2581
public class BOJ2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;
        for (int i = n; i >= m; i--) {
            // i가 1이면 continue;
            if (i == 1) continue;
            // i가 소수이면
            if (isPrime(i)) {
                // sum에 더하고,
                sum += i;
                // min 에 값을 할당
                min = i;
            }
            // 아니면 continue;
            else continue;
        }
        if (min == -1) System.out.println(min);
        else System.out.println(sum + "\n" + min);
    }

    // 소수 판별볍, p * q = N 일 경우, 즉 합성수일 경우 -> p와 q 둘 중하나는 반드시 N의 제곱근 이하이다.
    // 에라토스테네스의 체, N 이하의 소수를 찾는 방법 : 2의 배수 제거, 3의 배수 제거, -> N의 제곱근까지 증가시키면서 반복
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

// 소수 판별 시, 작은 수부터
// 1위 정답 - https://www.acmicpc.net/source/1199051
class BOJ2581Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(token.nextToken());
        token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());

        boolean[] nums = new boolean[10001];

        nums[0] = nums[1] = true;

        for (int i = 2; i < 10001; i++) {
            if (nums[i]) {
                continue;
            }
            int temp = i;
            while (temp + i < 10001) {
                temp += i;
                nums[temp] = true;
            }
        }

        int result = 0;
        int min = 0;
        boolean noExist = false;
        for (int i = m; i <= n; i++) {
            if (!nums[i]) {
                if (min == 0) {
                    min = i;
                }
                result += i;
                noExist = true;
            }
        }

        if (!noExist) System.out.println("-1");
        else System.out.println(result + "\n" + min);
    }
}