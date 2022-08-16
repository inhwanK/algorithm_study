package algorithm_study.boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 괄호 - https://www.acmicpc.net/problem/9012
public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            String result = "YES";
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '(') {
                    count++;
                }
                if (c == ')') {
                    count--;
                    if (count < 0) {
                        result = "NO";
                        break;
                    }
                }
            }
            if (count != 0) {
                result = "NO";
            }
            System.out.println(result);
        }
    }
}

// String 타입을 toCharArray로 쉽게 배열로 만들 수 있음.
// 상위 정답 - https://www.acmicpc.net/source/10663368
class BOJ9012Answer {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0, j = 0;

        for (int i = 0; i < cases; i++) {
            char arr[] = br.readLine().toCharArray();
            if (arr[0] == ')') sb.append("NO\n");
            else {
                for (j = 0; j < arr.length; j++) {
                    if (arr[j] == '(') cnt++;
                    if (arr[j] == ')') cnt--;

                    if (cnt < 0) {
                        sb.append("NO\n");
                        break;
                    }
                }

                if (j == arr.length) {
                    if (cnt == 0) sb.append("YES\n");
                    else sb.append("NO\n");
                }
                cnt = 0;
            }
        }
        System.out.println(sb);
    }
}