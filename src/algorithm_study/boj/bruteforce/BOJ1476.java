package algorithm_study.boj.bruteforce;

import java.io.*;

// 날짜 계산 - https://www.acmicpc.net/problem/1476
public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] years = br.readLine().split(" ");

        int e = Integer.parseInt(years[0]);
        int s = Integer.parseInt(years[1]);
        int m = Integer.parseInt(years[2]);

        long sTemp = e;
        long mTemp = e;

        long count = e;
        while (true) {
            sTemp = sTemp > 28 ? sTemp % 28 : sTemp;
            mTemp = mTemp > 19 ? mTemp % 19 : mTemp;

            if (sTemp == s && mTemp == m)
                break;

            sTemp += 15;
            mTemp += 15;

            count += 15;
        }
        System.out.println(count);
    }
}

// 내가 더 스마트하게 푼 듯
// 상위 정답 - https://www.acmicpc.net/source/15556559
class BOJ1476Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");

        int E = Integer.parseInt(in[0]);
        int S = Integer.parseInt(in[1]);
        int M = Integer.parseInt(in[2]);

        int y = 1;
        int e1 = 1;
        int s1 = 1;
        int m1 = 1;
        while (true) {


            if (e1 == E && s1 == S && m1 == M)
                break;

            e1++;
            s1++;
            m1++;

            y++;
            if (e1 > 15)
                e1 = 1;
            if (s1 > 28)
                s1 = 1;
            if (m1 > 19)
                m1 = 1;
        }
        System.out.println(y);
    }
}