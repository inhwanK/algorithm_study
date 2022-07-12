package algorithm_study.boj.map;

import java.io.*;
import java.util.*;

// 듣보잡 - https://www.acmicpc.net/problem/1764
public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        Collections.sort(list);
        sb.append(list.size());
        for (int i = 0; i < list.size(); i++) {
            sb.append('\n');
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}

// 배열을 미리 정렬하여 사전 순으로 출력되게 함.
// 듣도 못한 사람과 보도 못한 사람 인덱스를 직접 조작하여 검색 과정을 최적화함.
// 상위 정답 - https://www.acmicpc.net/source/26064653
class BOJ1764Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        String[] notHeard = new String[n];
        String[] notSeen = new String[m];

        for (int i = 0; i < n; i++) {
            notHeard[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            notSeen[i] = br.readLine();
        }

        Arrays.sort(notHeard);
        Arrays.sort(notSeen);

        List<String> notHeardSeen = new ArrayList<>();
        int heardCurr = 0, seenCurr = 0;
        while (heardCurr < n && seenCurr < m) {
            int compare = notHeard[heardCurr].compareTo(notSeen[seenCurr]);

            if (compare == 0) {
                notHeardSeen.add(notHeard[heardCurr]);
                heardCurr++;
                seenCurr++;
            } else if (compare > 0) {
                seenCurr++;
            } else {
                heardCurr++;
            }
        }

        bw.write(notHeardSeen.size() + "\n");
        for (String element : notHeardSeen) {
            bw.write(element + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }

    private static void PrintList(List<Integer> list) {
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// 배열에 구분없이 한번에 받아서 이전 인덱스와 비교함. 훨씬 바람직한 풀이 방법 같음.
// 상위 정답 - https://www.acmicpc.net/source/7133126
class BOJ1764Answer_2 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
        int N = Integer.parseInt(st.nextToken()); // didn't hear
        int M = Integer.parseInt(st.nextToken()); // didn't see

        String[] notSH = new String[N+M];

        for(int i = 0; i < N + M; i++){
            notSH[i] = br.readLine();

        }
        Arrays.sort(notSH);

        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N + M; i++){
            if(notSH[i].equals(notSH[i - 1])){
                sb.append(notSH[i]).append(NEW_LINE);
                cnt++;
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}