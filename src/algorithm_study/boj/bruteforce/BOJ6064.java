package algorithm_study.boj.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카잉 달력 - https://www.acmicpc.net/problem/6064
public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] in = br.readLine().split(" ");
            int m = Integer.parseInt(in[0]);
            int n = Integer.parseInt(in[1]);
            int x = Integer.parseInt(in[2]);
            int y = Integer.parseInt(in[3]);

            if (m == n && x == y) {
                sb.append(x).append('\n');
                continue;
            } else if (m == n && x != y) {
                sb.append(-1).append('\n');
                continue;
            }

            int count = 0;
            int target = 0;
            int div = 0;
            int plus = 0;

            if (m > n) {
                count = x;
                target = y;
                div = n;
                plus = m;
            } else {
                count = y;
                target = x;
                div = m;
                plus = n;
            }

            while (true) {
                if (count > m * n) {
                    count = -1;
                    break;
                }

                int temp = count % div == 0 ? div : count % div;
                if (temp == target) break;
                count += plus;
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}

// 어케 푼거죠?
// 상위 정답 - https://www.acmicpc.net/source/8628165
class BOJ6064Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int M, N, x, y, testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(M < N ? calc(N, M, y, M == x ? 0 : x) : calc(M, N, x, N == y ? 0 : y));
            sb.append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
    private static int calc (int paramM, int paramN, int paramX, int paramY) {
        int tmp1 = paramM, tmp2 = paramN, max = 1;
        while (max > 0) {
            max = tmp1 % tmp2;
            tmp1 = tmp2;
            tmp2 = max;
        }
        max = paramN / tmp1;
        for (tmp2 = 0; tmp2 < max; tmp2++) {
            tmp1 = tmp2 * paramM + paramX;
            if (tmp1 % paramN == paramY) break;
        }
        return tmp2 == max ? -1 : tmp1;
    }
}