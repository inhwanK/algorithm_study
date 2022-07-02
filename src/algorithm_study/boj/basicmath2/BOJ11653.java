package algorithm_study.boj.basicmath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소인수분해 - https://www.acmicpc.net/problem/11653
public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int temp = n;
        int i = 2;
        while (true) {
            if(temp == 1) break;
            if (i > Math.sqrt(n)) {
                System.out.println(temp);
                break;
            } else if (temp % i == 0) {
                temp /= i;
                System.out.println(i);
                i = 2;
            } else i++;
        }
    }
}

// 다음엔 StringBuilder를 써보자, n = 1 일 때는 굳이 신경안써도 출력안되게끔 하면됨
// 상위 정답 - https://www.acmicpc.net/source/5161197
class BOJ11653Answer {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 2; i*i<=n; i++) {
            while(n%i == 0) {
                sb.append(i).append('\n');
                n /= i;
            }
        }
        if(n != 1) {
            sb.append(n);
        }
        System.out.println(sb);
    }
}