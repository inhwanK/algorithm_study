package algorithm_study.boj.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀의 귀재 - https://www.acmicpc.net/problem/25501
public class BOJ25501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int count = 1;
            for (int j = 0; j < input.length / 2; j++) {
                if (input[0 + j] != input[input.length - 1 - j]) {
                    break;
                }
                count++;
            }

            if (count == input.length / 2 + 1) {
                System.out.println(1 + " " + count);
            } else {
                System.out.println(0 + " " + count);
            }
        }
    }
}

// 그냥 메소드 구현해서 세버림 - https://www.acmicpc.net/source/49130728
class BOJ25501Answer {
    static int recTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            recTime = 1;
            sb.append(isPalindrome(br.readLine()) + " " + recTime + "\n");
        }
        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r) {
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else {
            recTime++;
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}