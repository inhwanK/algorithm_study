package algorithm_study.boj.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 대칭 차집합 - https://www.acmicpc.net/problem/1269
public class BOJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // 전체 수와 교집합을 구한 뒤, 교집합 * 2만큼을 전체수에서 빼면 됨.
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int sum = n + m;

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < sum; i++) {
            int element = -1;
            if (i < a.length)
                element = Integer.parseInt(a[i]);
            else
                element = Integer.parseInt(b[i - a.length]);

            if (set.contains(element)) count++;
            set.add(element);
        }
        System.out.println(set.size() - count);
    }
}

// 큰 차이는 없음...
// 상위 정답 - https://www.acmicpc.net/source/29541003
class BOJ1269Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        int dupCnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) set.add(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) if (set.contains(st.nextToken())) dupCnt++;

        System.out.println(a + b - 2 * dupCnt);
    }
}