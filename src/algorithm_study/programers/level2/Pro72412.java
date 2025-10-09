package algorithm_study.programers.level2;

import java.util.*;

// 순위 검색 - https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class Pro72412 {
    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map.clear();

        // 1️⃣ 지원자 정보 전처리: 가능한 모든 조합(16가지)을 key로 저장
        for (String s : info) {
            String[] arr = s.split(" ");
            makeKeys(arr, 0, "", Integer.parseInt(arr[4]));
        }

        // 2️⃣ 각 키별 점수 리스트 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // 3️⃣ 쿼리 처리
        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");
            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int score = Integer.parseInt(arr[4]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            List<Integer> list = map.get(key);
            int idx = lowerBound(list, score); // 이분 탐색
            answer[i] = list.size() - idx;
        }

        return answer;
    }

    // 가능한 모든 조합을 만들어 Map에 추가 (DFS)
    private void makeKeys(String[] arr, int depth, String key, int score) {
        if (depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        makeKeys(arr, depth + 1, key + arr[depth], score);  // 해당 속성 사용
        makeKeys(arr, depth + 1, key + "-", score);         // '-' 대체 사용
    }

    // 점수 하한 이분 탐색 (lower bound)
    private int lowerBound(List<Integer> list, int target) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
