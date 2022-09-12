package algorithm_study.boj.step.deque;


import java.util.*;
import java.io.*;

// 요세푸스 문제 0 - https://www.acmicpc.net/problem/11866
public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] result = new int[n];

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int count = 0;
        int temp = k - 1;
        while (count < n) {
            result[count] = list.get(temp);
            System.out.println(result[count]);
            temp = (list.get(temp) + k); //% list.size() == 0 ? ;
            System.out.println(temp % list.size() - 1);
            temp = temp % list.size() == 0 ? list.size() - 1 : temp % list.size();

            list.remove(temp);

            count++;
        }

        sb.append('<');
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if (i == n - 1) {
                sb.append('>');
                break;
            }
            sb.append(", ");
        }
        System.out.println(sb);
    }
}
