package algorithm_study.boj.codeplus.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 스택 - https://www.acmicpc.net/problem/10828
public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                int x = Integer.parseInt(input[1]);
                list.add(x);
            }

            if (input[0].equals("pop")) {
                if (list.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(list.get(list.size() - 1)).append('\n');
                list.remove(list.size() - 1);
            }

            if (input[0].equals("size")) {
                sb.append(list.size()).append('\n');
            }

            if (input[0].equals("empty")) {
                if (list.isEmpty()) {
                    sb.append(1).append('\n');
                    continue;
                }
                sb.append(0).append('\n');
            }

            if (input[0].equals("top")) {
                if (list.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(list.get(list.size() - 1)).append('\n');

            }
        }
        System.out.println(sb);
    }
}