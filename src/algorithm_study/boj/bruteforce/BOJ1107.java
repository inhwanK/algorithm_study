package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 리모컨 - https://www.acmicpc.net/problem/1107
public class BOJ1107 {
    public static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int in = Integer.parseInt(br.readLine());
        if (in != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < in; i++) {
                int n = Integer.parseInt(st.nextToken());
                broken[n] = true;
            }
        }


    }

    public static boolean isPossible(int num) {
        if (num < 0) return false;

        String input = num + "";
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - '0';
            if (broken[index] == true) return false;
        }
        return true;
    }
}

class BOJ1107Answer {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = Math.abs(100 - ch);
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int idx = Integer.parseInt(st.nextToken());
                broken[idx] = true;
            }
        }

        if (m != 10) {
            if (isPossible(ch)) {
                answer = Math.min(answer, String.valueOf(ch).length());
            } else {
                int idx = 1;
                while (true) {
                    if ((ch - idx) >= 0 && isPossible(ch - idx)) {
                        answer = Math.min(answer, String.valueOf(ch - idx).length() + idx);
                        break;
                    }
                    if (isPossible(ch + idx)) {
                        answer = Math.min(answer, String.valueOf(ch + idx).length() + idx);
                        break;
                    }
                    idx++;
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int ch) {
        int chk = ch;
        if (chk == 0) return !broken[0];
        while (chk != 0) {
            if (broken[chk % 10])
                return false;
            chk = chk / 10;
        }
        return true;
    }
}