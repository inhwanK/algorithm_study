package algorithm_study.boj.step.basicmath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 예외처리를 잘 해야하는데 어케 발견하죠?
// ACM 호텔 - https://www.acmicpc.net/problem/10250
public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            int num = 0;
            int floor = 0;

            if(n % h == 0) {
                floor = h;
                num = n / h;
            } else {
                floor = n % h;
                num = n / h + 1;
            }
            int result = floor * 100 + num;

            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}

// 1위 정답 - https://www.acmicpc.net/source/7845713
class BOJ10250Answer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int h, w, n;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(n%h != 0) str.append(n%h);
            else str.append(h);

            if(n/h < 9 || (n/h==9) && (n%h==0)) str.append(0);
            if (n%h != 0) str.append(n/h + 1);
            else str.append(n/h);
            str.append("\n");
        }
        System.out.print(str.toString());
    }
}