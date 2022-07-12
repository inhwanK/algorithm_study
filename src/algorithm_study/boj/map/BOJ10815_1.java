package algorithm_study.boj.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 숫자 카드 - https://www.acmicpc.net/problem/10815
public class BOJ10815_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        int n = Integer.parseInt(br.readLine());
        String[] owns = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        // map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(owns[i]), 1);
        }
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(cards[i]);
            sb.append(map.getOrDefault(card, 0)).append(" ");
        }
        System.out.println(sb);
    }
}

class BOJ10815_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 입력
        int n = Integer.parseInt(br.readLine());
        String[] owns = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        // set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(owns[i]));
        }
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(cards[i]);
            if (set.contains(card)) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

// read() 메서드를 구현하여 속도를 빠르게 함. 풀이는 나와 거의 동일함
// 상위 정답 - https://www.acmicpc.net/source/43322051
class BOJ10815Answer {

    public static void main(String[] args) throws Exception {

        int N = read();
        Set<Integer> cards = new HashSet<>(N);
        while (N-- > 0) cards.add(read());

        int M = read();
        StringBuilder sb = new StringBuilder();
        while (M -- > 0) sb.append(cards.contains(read()) ? 1 : 0).append(' ');

        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}