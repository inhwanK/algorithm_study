package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 부등호 - https://www.acmicpc.net/problem/2529
public class BOJ2529 {
    static int k;
    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
    static String minValue, maxValue;
    static boolean[] visited;
    static char[] ine, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        visited = new boolean[10];
        ine = new char[k];
        arr = new char[k + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            ine[i] = input[i].charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            arr[0] = (char) (i + '0');
            recursion(1);
            visited[i] = false;
        }

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void recursion(int depth) {
        if (depth == k + 1) {
            String output = "";
            for (int i = 0; i < k + 1; i++) {
                output += arr[i];
            }
            long result = Long.parseLong(output);

            if (max < result) {
                max = result;
                maxValue = output;
            }
            if (min > result) {
                min = result;
                minValue = output;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if ((ine[depth - 1] == '<' && arr[depth - 1] - '0' < i) || (ine[depth - 1] == '>' && arr[depth - 1] - '0' > i)) {
                    visited[i] = true;
                    arr[depth] = (char) (i + '0');
                    recursion(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
}

class BOJ2529Answer {

    static boolean[] check = new boolean[10]; // 0~9까지 check
    static int n;
    static char[] a = new char[10]; // 부등호는 최대 9개임
    static ArrayList ans = new ArrayList<>();

    static boolean ck(char a, char b, char c) {
        if (c == '<') {
            if (a > b) {
                return false;
            }
        }
        if (c == '>') {
            if (a < b) {
                return false;
            }
        }
        return true;
    }

    static void go(int index, String num) {
        if (index == n + 1) {
            ans.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i])
                continue;
            if (index == 0 || ck(num.charAt(index - 1), (char) (i + '0'), a[index - 1])) {
                check[i] = true;
                go(index + 1, num + Integer.toString(i));
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray()[0];
        }
        go(0, "");
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
    }
}