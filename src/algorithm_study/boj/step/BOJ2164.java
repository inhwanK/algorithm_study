package algorithm_study.boj.step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 카드2 - https://www.acmicpc.net/problem/2164
public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}

// dp 처럼 푼 듯
// 상위 정답 - https://www.acmicpc.net/source/35818375
class BOJ2164Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int temp = 1;
        int answer = 1;
        while (N != 1) {
            if (N - temp <= 0) {
                answer = (N - temp / 2) * 2;
                break;
            }
            temp *= 2;
        }
        sb.append(answer);
        System.out.println(sb);
    }
}