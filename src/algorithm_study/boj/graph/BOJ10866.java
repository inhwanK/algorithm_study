package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 덱 - https://www.acmicpc.net/problem/10866
public class BOJ10866 {
    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push_front")) {
                deque.offerFirst(Integer.parseInt(input[1]));
                continue;
            }

            if (input[0].equals("push_back")) {
                deque.offerLast(Integer.parseInt(input[1]));
                continue;
            }

            if (input[0].equals("pop_front")) {
                if (deque.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deque.pollFirst()).append('\n');
                continue;
            }

            if (input[0].equals("pop_back")) {
                if (deque.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deque.pollLast()).append('\n');
                continue;
            }

            if (input[0].equals("size")) {
                sb.append(deque.size()).append('\n');
                continue;
            }

            if (input[0].equals("empty")) {
                if (deque.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
                continue;
            }

            if (input[0].equals("front")) {
                if (deque.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deque.peekFirst()).append('\n');
                continue;
            }

            if (input[0].equals("back")) {
                if (deque.isEmpty()) sb.append(-1).append('\n');
                else sb.append(deque.peekLast()).append('\n');
                continue;
            }
        }

        System.out.println(sb);
    }
}