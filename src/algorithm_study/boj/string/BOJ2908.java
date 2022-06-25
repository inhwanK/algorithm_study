package algorithm_study.boj.string;

import java.io.*;

// 상수 - https://www.acmicpc.net/problem/2908
public class BOJ2908 {
    public static String first = "", second = "";

    public static void main(String[] args) throws IOException {
        // 바이트를 쓸 수 있을까?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num = br.readLine();

        first += num.charAt(2);
        first += num.charAt(1);
        first += num.charAt(0);

        second += num.charAt(6);
        second += num.charAt(5);
        second += num.charAt(4);

        int max = Integer.parseInt(first);
        max = Math.max(max, Integer.parseInt(second));

        bw.write(max + "");

        bw.close();
        br.close();
    }
}

// 다음엔 바이트 꼭쓴다 ㅂㄷㅂㄷ
// 1위 정답 - https://www.acmicpc.net/source/7581463
class BOJ2908Anser {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int[] A = new int[3];
        int[] B = new int[3];
        for (int i = 0; i < A.length; i++) {
            A[i] = System.in.read()-'0';
        }
        System.in.read();
        for (int i = 0; i < B.length; i++) {
            B[i] = System.in.read()-'0';
        }
        int tA = A[0]+A[1]*10+A[2]*100;
        int tB = B[0]+B[1]*10+B[2]*100;
        System.out.println(tA>tB? tA : tB );
    }

}