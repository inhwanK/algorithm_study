package algorithm_study.boj.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 숫자인 1~9까지의 아스키 코드 값은 49~57이다.
// String.charAt(0)이 49~57 범위안에 드는 값이면 번호

// 상위 정답과 동일
// 나는야 포켓몬 마스터 이다솜 - https://www.acmicpc.net/problem/1620
public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashMap<String, Integer> map = new HashMap<>();
        String[] pocket = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            pocket[i] = br.readLine();
            map.put(pocket[i], i);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (name.charAt(0) >= 49 && name.charAt(0) <= 57) {
                int num = Integer.parseInt(name);
                sb.append(pocket[num]).append('\n');
            } else {
                sb.append(map.get(name)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
