package algorithm_study.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 승점구하기
public class Points {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        System.out.println(calcPoint(input));
    }

    private static int calcPoint(String[] input) {
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            String[] score = input[i].split(":");

            int left = Integer.parseInt(score[0]);
            int right = Integer.parseInt(score[1]);
            if (left > right) {
                result += 3;
            } else if (left == right) {
                result += 1;
            }
        }

        return Math.min(result, 4);
    }
}