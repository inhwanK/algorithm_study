package algorithm_study.boj.step.string;

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

// 1위 정답 - https://www.acmicpc.net/source/10307828
class BOJ1316Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (T-- > 0) {
            String str = br.readLine();
            boolean[] ck = new boolean[26];
            boolean group = true;
            char old = str.charAt(0);
            ck[old-97] = true;
            for (int i = 1; i < str.length(); i++) {
                char nw = str.charAt(i);
                if (!ck[nw-97] && nw != old) {
                    ck[nw-97] = true;
                    old = str.charAt(i);
                }
                else if (ck[nw-97] && nw != old) {
                    group = false;
                    break;
                }

            }
            if (group) cnt++;
        }
        System.out.println(cnt);
    }
}