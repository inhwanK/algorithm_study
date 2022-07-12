package algorithm_study.boj.map;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

// 서로 다른 부분 문자열의 개수 - https://www.acmicpc.net/problem/11478
public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}

// 상위 정답 - https://www.acmicpc.net/source/11724982
class BOJ11478Answer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int length = input.length();
        String[] suff_arr = new String[length];
        int lcp = 0;
        for (int i = 0; i < length; i++) {
            suff_arr[i] = input.substring(length - 1 - i);
        }
        Arrays.sort(suff_arr);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < suff_arr[i - 1].length(); j++) {
                if (suff_arr[i - 1].charAt(j) == suff_arr[i].charAt(j)) {
                    lcp++;
                } else {
                    break;
                }
            }
        }
        int ans = (length * (length + 1) / 2 - lcp);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

}
