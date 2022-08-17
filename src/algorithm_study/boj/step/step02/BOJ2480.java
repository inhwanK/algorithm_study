package algorithm_study.boj.step.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 주사위 세개 - https://www.acmicpc.net/problem/2480
public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        if (first == second && second == third) {
            System.out.println(first * 1000 + 10000);
        } else if (first == second || second == third || first == third) {
            if (first == second) System.out.println(first * 100 + 1000);
            else System.out.println(third * 100 + 1000);
        } else {
            int max = Math.max(first, second);
            max = Math.max(max, third);
            System.out.println(max * 100);
        }
        br.close();
    }
}

// 똑똑하게 풀엇넹...
// 상위 정답 - https://www.acmicpc.net/source/40123295
class BOJ2480Answer {
    static int[] countArr = new int[7];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens())
            countArr[Integer.parseInt(st.nextToken())]++;

        int result = 0;
        for(int i = 0; i < countArr.length; i++) {
            if(countArr[i] == 2) {
                result = 1000 + i*100;
                break;
            }
            if(countArr[i] == 3) {
                result = 10000 + i*1000;
                break;
            }

            if(countArr[i] == 1 && i > result)
                result = i;
        }

        if(result < 1100)
            result *= 100;

        System.out.print(result);
    }
}