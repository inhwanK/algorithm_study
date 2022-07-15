package algorithm_study.boj;

import java.io.*;

// 문제 풀이 아이디어 - https://codejb.tistory.com/4
// 약수의 합 2 - https://www.acmicpc.net/problem/17427
public class BOJ17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //  1~7까지 자연수 중에서 7의 배수의 개수 = 약수 7을 가진 값들의 개수 = 7을 약수로 갖는 값의 개수 = N/7
        // overflow 발생할 수 있음.
        long gn = 0;
        for (int i = 1; i <= n; i++) {
            gn += (n / i) * i;
        }

        bw.write(gn + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

// 풀이 거의 동일
// 상위 정답 - https://www.acmicpc.net/source/24686438
class BOJ17427Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        System.out.println(yaksuSum(num));
    }

    public static long yaksuSum(int a) {
        long sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i * (a/i);
        }
        return sum;
    }
}