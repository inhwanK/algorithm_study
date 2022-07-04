package algorithm_study.boj.recursion;

import java.io.*;
import java.math.BigInteger;

// 하노이 탑 이동 순서 - https://www.acmicpc.net/problem/11729
public class BOJ11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count * 2 + 1;
        }
        sb.append(count).append("\n");
        move(n, 1, 3, 2);

        System.out.println(sb);
    }

    public static void move(int n, int departIndex, int arriveIndex, int mid) {
        if (n == 0) return;
        move(n - 1, departIndex, mid, arriveIndex);
        sb.append(departIndex).append(" ").append(arriveIndex).append("\n");
        move(n - 1, mid, arriveIndex, departIndex);
    }
}

// 상위 정답 - https://www.acmicpc.net/source/15096389
class BOJ11729Answer {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solve(int n, int a, int b, int c) {
        if (n == 0)
            return;
        solve(n - 1, a, c, b);
        sb.append(a).append(' ').append(c).append('\n');
        //System.out.println(a + " " + c);
        solve(n - 1, b, a, c);
    }

    static BigInteger getCount(int n) {
        return (new BigInteger("2")).pow(n).subtract(new BigInteger("1"));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger ret = getCount(n);
        bw.write(ret + "\n");
        solve(n, 1, 2, 3);
        bw.write(sb.toString());
        bw.flush();
    }

}