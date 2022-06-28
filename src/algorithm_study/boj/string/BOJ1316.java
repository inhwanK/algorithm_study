package algorithm_study.boj.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 그룹 단어 체커 - https://www.acmicpc.net/problem/1316
public class BOJ1316 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 포인터가 바뀌었는데, 해당 인덱스의 요소가 0보다 크면, 그룹 단어가 아니다.
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int[] arr = new int[26];
            int pre = 0;
            int now = 0;

            for (int j = 0; j < word.length(); j++) {
                pre = now;
                now = word.charAt(j) - 'a';
                if (pre != now && arr[now] > 0) {
                    count--;
                    break;
                }
                arr[now] += 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
