package algorithm_study.boj.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 숫자 카드 2 - https://www.acmicpc.net/problem/10816
public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (!map.containsKey(number)) map.put(number, 1);
            else map.put(number, map.get(number) + 1);
        }
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(cards[i]);
            int count = map.getOrDefault(card, 0);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}

// 계수 정렬을 이용한 풀이 - https://st-lab.tistory.com/267
class BOJ10816Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] counting = new int[20000001]; // 입력받는 수의 범위 : -10,000,000 ~ 10,000,000
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            counting[Integer.parseInt(st.nextToken()) + 10000000]++;    // 해당 인덱스의 값 증가
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(counting[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
        }
        System.out.println(sb);
    }
}