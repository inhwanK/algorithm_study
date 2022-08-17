package algorithm_study.boj.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이얼 - https://www.acmicpc.net/problem/5622
public class BOJ5622 {
    public static int num = 0, sum = 0;

    public static void main(String[] args) throws IOException {

        int[] numbers = new int[11];
        int index = 0;
        while (true) {
            num = System.in.read();
            // 문자열이 끝나면 종료
            if (num == '\n') break;
            // O까지
            if (num < 'P') {
                index = num - 'A';
                numbers[(index / 3) + 2]++;
            }
            // P ~ S 까지
            else if (num < 'T') numbers[7]++;
            // T ~ V 까지
            else if (num < 'W') numbers[8]++;
            // W ~ Z 까지
            else numbers[9]++;
        }

        for (int i = 1; i < 10; i++) {
            sum += (i + 1) * numbers[i];
        }
        System.out.print(sum);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/8959679
class BOJ5622Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int[] alpha = new int[26];
        char[] word = S.toCharArray();
        for (int i = 0; i < alpha.length; i++) {

            if ((i >= 15 && i <= 18)) {
                alpha[i] = 8;
            } else if (i >= 19 && i <= 21) {
                alpha[i] = 9;
            } else if ((i >= 22)) {
                alpha[i] = 10;
            } else {
                alpha[i] = (i / 3) + 3;
            }
        }

        int time = 0;
        for (int i = 0; i < word.length; i++) {
            time += alpha[word[i] - 65];
        }
        System.out.println(time);
    }
}