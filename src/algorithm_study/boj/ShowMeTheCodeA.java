package algorithm_study.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 신을 모시는 사당 - https://showmethecode.acmicpc.net/contest/problem/940/1
public class ShowMeTheCodeA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int answer = 0;

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(input[i]);

            if(leftCount < 0) {
                leftCount = 0;
            }

            if(rightCount < 0) {
                rightCount = 0;
            }

            if(target == 1) {
                leftCount += 1;
                rightCount -= 1;
            } else {
                leftCount -= 1;
                rightCount += 1;
            }

            answer = Math.max(answer, Math.max(leftCount, rightCount));
        }

        System.out.println(answer);
    }
}
