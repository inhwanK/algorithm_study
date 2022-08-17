package algorithm_study.boj.step.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다 - https://www.acmicpc.net/problem/2869
public class BOJ2869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int step = a - b;
        int day = ((v - a) / step) + 1;
        if ((v - a) % step != 0) {
            day++;
        }
        System.out.println(day);
    }
}

// 큰 차이 없음
// 상위 정답 - https://www.acmicpc.net/source/41661555
class BOJ2869Answer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) day++;
        System.out.print(day);
    }
}