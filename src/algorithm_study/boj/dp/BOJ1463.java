package algorithm_study.boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기 - https://www.acmicpc.net/problem/1463
public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] arr = new int[1000001];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= x; i++) {
            int min = arr[i - 1] + 1;
            if (i % 3 == 0) {
                min = Math.min(min, arr[i / 3] + 1);
            }
            if (i % 2 == 0) {
                min = Math.min(min, arr[i / 2] + 1);
            }
            arr[i] = min;
        }
        System.out.println(arr[x]);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/11835772
class BOJ1463Answer {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(recursive(n, 0));
        br.close();
    }

    public static int recursive(int value, int count) {
        if (value == 1 || value == 0)
            return count;
        else {
            // 2로 나눠지지 않더라도, 나머지 값을 count에 더하기 때문에 count를 구할 수 있음
            int cal2 = recursive(value / 2, count + 1 + (value % 2));
            // 3로 나눠지지 않더라도, 나머지를 count에 더하기 때문에 count를 구할 수 있음
            // 만약 나머지가 없다면, 나머지가 없는대로 구해지기 때문에 정상적인 count값을 구할 수 있음
            int cal3 = recursive(value / 3, count + 1 + (value % 3));
            return Math.min(cal2, cal3);
        }
    }
}