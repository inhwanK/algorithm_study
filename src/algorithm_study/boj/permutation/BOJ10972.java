package algorithm_study.boj.permutation;

import java.util.*;
import java.io.*;

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

        int division = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                division = i - 1;
                break;
            }
        }

        System.out.print(" > ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = n - 1; i > 0; i--) {
            if (arr[division] < arr[i]) {
                int swap = arr[i];
                arr[i] = arr[division];
                arr[division] = swap;
                break;
            }
        }

        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        int left = division + 1;
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