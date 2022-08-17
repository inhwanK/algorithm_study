package algorithm_study.boj.step.basicmath1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 큰 수 A+B - https://www.acmicpc.net/problem/10757
public class BOJ10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());

        System.out.println(a.add(b));
        br.close();
    }
}

// 직접 구현해보기 너무 귀찮은데...
// 상위 정답 - https://www.acmicpc.net/source/16156875
class BOJ10757Answer {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");

        int flag = 0;

        for (int i = inputs[0].length() - 1, j = inputs[1].length() - 1; i >= 0 || j >= 0; i--, j--) {
            int num = flag;

            if (i >= 0) num += inputs[0].charAt(i) - '0';

            if (j >= 0) num += inputs[1].charAt(j) - '0';


            if (num < 10) flag = 0;
            else {
                flag = 1;
                num -= 10;
            }

            sb.append(num);
        }

        if (flag == 1) sb.append(1);

        System.out.println(sb.reverse());
    }
}