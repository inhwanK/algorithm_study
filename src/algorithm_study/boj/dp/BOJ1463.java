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
class Main {
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
            int cal2 = recursive(value / 2, count + 1 + (value % 2));
            int cal3 = recursive(value / 3, count + 1 + (value % 3));
            return Math.min(cal2, cal3);
        }
    }
}