package algorithm_study.boj.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다음 순열 - https://www.acmicpc.net/problem/10972
public class BOJ10972 {
    static int n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int divIndex = divArea();

        if (divIndex == -1) {
            System.out.println(divIndex);
        } else {
            for (int i = n - 1; i > 0; i--) {
                if (arr[divIndex] < arr[i]) {
                    int swap = arr[i];
                    arr[i] = arr[divIndex];
                    arr[divIndex] = swap;
                    break;
                }
            }

            int left = divIndex + 1;
            int right = n - 1;

            while (left < right) {
                int swap = arr[left];
                arr[left] = arr[right];
                arr[right] = swap;

                right--;
                left++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static int divArea() {
        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                index = i - 1;
                break;
            }
        }
        return index;
    }
}

class BOJ10972Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visit = new boolean[n];
        String answer = "";
        int where = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                answer = String.valueOf(-1);
                break;
            }

            visit[array[i] - 1] = true;
            if (array[i] > array[i - 1]) {
                for (int j = array[i - 1]; j < n; j++) {
                    if (visit[j]) {
                        visit[array[i - 1] - 1] = true;
                        array[i - 1] = j + 1;
                        visit[j] = false;
                        break;
                    }
                }
                where = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (where != -1) {
            for (int i = 0; i < where; i++) {
                sb.append(array[i]).append(" ");
            }
            for (int i = 0; i < n; i++) {
                if (visit[i]) sb.append(i + 1).append(" ");
            }
            answer = sb.toString();
        }
        System.out.println(answer);
    }
}