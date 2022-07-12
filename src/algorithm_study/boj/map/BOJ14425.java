package algorithm_study.boj.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

// 상위 정답과 코드가 거의 동일함 - https://www.acmicpc.net/source/27098827
// 문자열 집합 - https://www.acmicpc.net/problem/14425
public class BOJ14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) count++;
        }
        System.out.println(count);
    }
}