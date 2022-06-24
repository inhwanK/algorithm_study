package algorithm_study.boj.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
2
3 ABC
5 /HTP
*/
// 문자열 반복 - https://www.acmicpc.net/problem/2675
public class BOJ2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String result = "";
        for (int i = 0; i < t; i++) {
            int r = sc.nextInt();
            String s = sc.next();
            for (int count = 0; count < s.length(); count++) {
                for (int repeat = 0; repeat < r; repeat++) {
                    result += s.charAt(count);
                }
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
// 1위 정답 - https://www.acmicpc.net/source/10642931
class BOJ2675Answer {
    private static int T;
    private static int repeat;
    private static char[] chArray, resultArray;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            repeat = Integer.parseInt(st.nextToken());
            chArray = st.nextToken().toCharArray();

            resultArray = new char[repeat * chArray.length];

            setData();
            print(bw);
        }
        bw.flush();
        bw.close();
    }

    private static void setData() {
        int index = 0;
        for (int i = 0; i < chArray.length; i++) {
            for (int j = 0; j < repeat; j++) {
                resultArray[index++] = chArray[i];
            }
        }
    }

    private static void print(BufferedWriter bw) throws Exception {
        for (int i = 0; i < resultArray.length; i++) {
            bw.write(String.valueOf(resultArray[i]));
        }
        bw.newLine();
    }
}