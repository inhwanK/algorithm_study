package algorithm_study.boj.step.sort;

import java.io.*;
import java.util.*;

// 단어 정렬 - https://www.acmicpc.net/problem/1181
public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List wordList = new ArrayList<String>();
        for (String word : set) {
            wordList.add(word);
        }
        Collections.sort(wordList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i));
        }
    }
}

// 중복처리를 위한 처리를 따로 하고, 그냥 배열에 담음
// 상위 정답 - https://www.acmicpc.net/source/18087975
class BOJ1181Answer_1 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return 1;
                    } else {
                        if (o1.length() == o2.length()) {
                            return o1.compareTo(o2);
                        } else {
                            return -1;
                        }
                    }
                }
            });

            for (int i = 0; i < N; i++) {
                if (i > 0 && arr[i - 1].equals(arr[i])) continue;
                bw.write(arr[i]);
                bw.newLine();
            }
            bw.flush();
        }
    }
}

// TreeSet을 사용해서 바로 중복처리와 정렬을 동시에 가능하게 함.
// 상위 정답2 - https://www.acmicpc.net/source/12970265
class BOJ1181Answer_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o1.length() < o2.length() ? -1 : 1;
            }
        });
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append("\n");
        }
        System.out.println(sb.toString());
    }
}