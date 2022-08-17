package algorithm_study.boj.step.string;

import java.io.*;
import java.util.StringTokenizer;

// 단어의 개수 - https://www.acmicpc.net/problem/1152
public class BOJ1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        input = input.trim();

        StringTokenizer st;
        st = new StringTokenizer(input);
        int count = st.countTokens();

        bw.write(count + "");

        br.close();
        bw.close();
    }
}

// 바이트로 받네..?
// 상위 정답 - https://www.acmicpc.net/source/33119866
class BOJ1152Anser {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        int pre = ' ';
        while (true) {
            int ch = System.in.read();
            if(ch == '\n') {
                if(pre != ' ') cnt++;
                break;
            }
            if(ch == ' ') {
                if(pre != ' ') cnt++;
            }
            pre = ch;
        }
        System.out.println(cnt);
    }
}