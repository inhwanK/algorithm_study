package algorithm_study.boj.step.step02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오븐 시계 - https://www.acmicpc.net/problem/2525
public class BOJ2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int minuteSum = b + c;
        int addition = (minuteSum / 60);
        a = (a + addition) % 24;
        b = minuteSum % 60;
        System.out.println(a + " " + b);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/12564097
class BOJ2525Answer {
    public static void main(String args[]) throws Exception {
        // 버퍼를 이용해 입력 값을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());
        br.close();

        // 시간 계산
        int sumMinutes = B + C;
        int hours = (A + sumMinutes / 60) % 24;
        int minutes = sumMinutes % 60;

        // 결과 값 출력
        System.out.println(new StringBuilder().append(hours).append(" ").append(minutes).toString());
    }
}