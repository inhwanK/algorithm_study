package algorithm_study.boj.step.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분수찾기 - https://www.acmicpc.net/problem/1193
public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int pre = 0;
        int sum = 1;
        int count = 1;
        while (x > sum) {
            pre = sum;
            sum += ++count;
        }
        x -= pre;
        if (count % 2 == 0) {
            System.out.println(x + "/" + (count - x + 1));
        } else {
            System.out.println((count - x + 1) + "/" + x);
        }
    }
}


// 1위 정답 - https://www.acmicpc.net/source/23506552
class BOJ1193Answer {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int sum = 0, i = 0;
        String result = "";

        while(true) {
            if(X <= sum) {
                break;
            } else {
                i++; // 그룹숫자내 최고의 수
                sum += i; // 계차수열 1, 3, 6, 10, 15, ...
            }
        }

        int num = sum - X;
        int Group = i+1;

        // 그룹숫자가 짝수인 경우
        if (Group % 2 == 0) {
            if(num != 0) {
                result = num+1 + "/" + (i-num);
            } else {
                result = 1 + "/" + i;
            }
            // 그룹숫자가 홀수인 경우
        } else {
            if(num != 0) {
                result = i-num + "/" + (num+1);
            } else {
                result = i + "/" + 1;
            }
        }

        System.out.print(result);
    }
}