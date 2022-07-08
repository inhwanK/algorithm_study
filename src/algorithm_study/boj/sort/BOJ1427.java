package algorithm_study.boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 소트인사이드 - https://www.acmicpc.net/problem/1427
public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        int[] arr = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = input.charAt(i) - '0';
        }

        Arrays.sort(arr);
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}

// 선택 정렬을 구현함, 근데 내 풀이가 현재는 더 빠른 듯?
// 1위 정답 - https://www.acmicpc.net/source/6299997
class BOJ1427Answer {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int size = str.length();
        int[] num = new int[size];
        int temp = 0;
        for (int i = 0; i < size; i++) {
            num[i] = Character.getNumericValue(str.charAt(i));
        }

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (num[i] < num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        for (int i : num) System.out.print(i);
    }
}