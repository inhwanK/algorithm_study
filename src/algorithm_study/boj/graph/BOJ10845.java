package algorithm_study.boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

// 큐와 그래프 - https://www.acmicpc.net/problem/10845
public class BOJ10845 {
    static List<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input.length > 1) {
                int x = Integer.parseInt(input[1]);
                q.add(x);
                continue;
            }

            String command = input[0];
            if (command.equals("pop")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.remove(0));
                continue;
            }

            if (command.equals("size")) {
                System.out.println(q.size());
                continue;
            }

            if (command.equals("empty")) {
                if (q.isEmpty()) System.out.println(1);
                else System.out.println(0);
                continue;
            }

            if (command.equals("front")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.get(0));
                continue;
            }

            if (command.equals("back")) {
                if (q.isEmpty()) System.out.println(-1);
                else System.out.println(q.get(q.size() - 1));
            }
        }
    }
}

// deque가 있었구나
// 상위 정답 - https://www.acmicpc.net/source/37658708
class BOJ10845Answer {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String command = br.readLine();
            switch (command) {
                case "pop":
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;
                case "back":
                    if (deque.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
                default:
                    deque.offer(command.substring(5));
                    break;
            }
        }
        System.out.print(sb);
    }
}