package algorithm_study.boj.permutation;

import java.util.*;
import java.io.*;

// 다음 순열 - https://www.acmicpc.net/problem/10972
public class BOJ10972 {
    static int n, arr[], temp[];
    static boolean visited[];
    static ArrayList<String> list;
    static String result = "-1";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n];
        list = new ArrayList<String>();
        String input = br.readLine();

        permutation(0);

        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(input)) {
                result = list.get(i + 1);
                break;
            }
        }
        System.out.println(result);
    }

    static void permutation(int depth) {
        if (depth == n) {
            String comp = "";
            for (int i = 0; i < n; i++) {
                comp += temp[i] + " ";
            }
            list.add(comp);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                temp[depth] = i;
                visited[i] = true;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}