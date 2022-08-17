package algorithm_study.boj.step.string;

import java.io.*;

// 단어 공부 - https://www.acmicpc.net/problem/1157
public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Mississipi
        zZa
        z
        baaa
        */
        String s = br.readLine();

        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if(Character.isUpperCase((char) ch))
                ch = ch - 'A';
            else
                ch = ch - 'a';

            word[ch] += 1;
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < word.length; i++) {
            if(word[i] > max){
                max = word[i];
                index = i;
            }
        }

        char result = (char) (index + 'A');
        for(int i = 0; i < word.length; i++){
            if(word[i] == max && i != index) {
                result = '?';
                break;
            }
        }

        bw.write(result);
        bw.close();
        br.close();
    }
}

// 바이트를 바로 받아서 풀어냄
// 상위 정답 - https://www.acmicpc.net/source/30036402
class BOJ1157Answer {
    public static void main(String[] args) throws IOException {

        int[] arr = new int[26];
        int c = System.in.read();
        while (c > 64) {
            if (c < 91) {
                arr[c - 65]++;
            } else {
                arr[c - 97]++;
            }
            c = System.in.read();
        }
        int max = -1;
        int ch = -2;
        for (int i = 0; i < 26; i++) {

            if (arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }

        System.out.println((char) (ch+65));
        System.out.print((char) (63)); // 63 은 물음표
    }
}