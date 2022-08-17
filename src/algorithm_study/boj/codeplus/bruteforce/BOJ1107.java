package algorithm_study.boj.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 설계는 했으나 구현을 정확히 못함...
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

        int answer = Math.abs(100 - target);
        if (in != 10) {
            // target이 숫자 버튼으로 바로 가능한 경우
            if (isPossible(target)) {
                answer = Math.min(answer, String.valueOf(target).length());
            } else { // 숫자 버튼으로 안되는 경우
                // 인덱스를 늘리면서 숫자버튼으로 접근 가능한 숫자 확인
                int idx = 1;
                while (true) {
                    if ((target - idx) >= 0 && isPossible(target - idx)) {
                        answer = Math.min(answer, String.valueOf(target - idx).length() + idx);
                        break;
                    }
                    if (isPossible(target + idx)) {
                        answer = Math.min(answer, String.valueOf(target + idx).length() + idx);
                        break;
                    }
                    idx++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isPossible(int num) {
        if (num < 0) return false;

        String input = String.valueOf(num);
        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i) - '0';
            if (broken[index]) return false;
        }
        return true;
    }
}

// 상위 정답 - https://www.acmicpc.net/source/22225533
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