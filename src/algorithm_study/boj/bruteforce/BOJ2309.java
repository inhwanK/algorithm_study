package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 일곱 난쟁이 - https://www.acmicpc.net/problem/2309
public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarf = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    dwarf[i] = -1;
                    dwarf[j] = -1;
                    Arrays.sort(dwarf);
                    for (int k = 2; k < 9; k++) {
                        System.out.println(dwarf[k]);
                    }
                    return;
                }
            }
        }
    }
}

// 풀이 큰 차이 없음
// 상위 정답 - https://www.acmicpc.net/source/8205814
class BOJ2309Answer {
    static int sum = 0;

    public static int solution(int[] input) {
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - input[i] - input[j] == 100)) {
                    input[i] = input[j] = 100;
                    return 0;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[9];
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }
        solution(input);
        Arrays.sort(input);
        for (int i = 0; i < 7; i++) {
            System.out.println(input[i]);
        }
    }
}