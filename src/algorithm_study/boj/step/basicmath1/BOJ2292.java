package algorithm_study.boj.step.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 벌집 - https://www.acmicpc.net/problem/2292
public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int max = 1;
        while(true){
            max = max + count * 6;
            if(n <= max) {
                break;
            }
            count++;
        }
        System.out.println(count + 1);
    }
}

//1위 정답 - https://www.acmicpc.net/source/9097682
class BOJ2292Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(solution(n));
    }

    private static int solution(int n) {
        // 1: 1 (1)
        // 2 ~ 7 : 2 (6개)
        // 8 ~ 19 : 3 (12개)
        // 20 ~ 37 : 4 (18개)
        // 38 ~ 61 : 5 (24개)
        // ...생략..
        // a(n) = a(n-1) + 6(n-1) | a(n): 첫 항
        if(n == 1) return 1;
        int i=2;
        int k=1;

        while(i<=n) {
            i += 6*k++;
        }

        return k;
    }
}