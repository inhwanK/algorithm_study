package algorithm_study.boj.step.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 나이순 정렬 - https://www.acmicpc.net/problem/10814
public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int old = Integer.parseInt(input[0]);
            String name = input[1];

            if (map.get(old) == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(name);
                map.put(old, list);
            } else {
                map.get(old).add(name);
            }
        }

        for (int key : map.keySet()) {
            int userLength = map.get(key).size();
            for (int i = 0; i < userLength; i++) {
                String userName = map.get(key).get(i);
                System.out.println(key + " " + userName);
            }
        }
    }
}

// 계수 정렬로 쉽게 풀 수 있음....
// 상위 정답 - https://www.acmicpc.net/source/41172393
class BOJ10814Answer {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] p = new StringBuilder[201];

        //객체배열의 인덱스에 각 StringBuilder 객체를 생성해준다.
        for (int i = 0; i < p.length; i++) {
            p[i] = new StringBuilder();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            // 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
            p[age].append(age).append(" ").append(name).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder val : p) {
            sb.append(val);
        }
        System.out.print(sb);
    }
}