package algorithm_study.programers.level2;

import java.util.*;

// 귤 고르기 - https://school.programmers.co.kr/learn/courses/30/lessons/138476
public class Pro138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap();
        PriorityQueue<int[]> heap = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int[] target = new int[2];

            target[0] = key;
            target[1] = map.get(key);
            heap.add(target);
        }

        while (k > 0) {
            int[] now = heap.poll();
            k -= now[1];
            answer++;
        }

        return answer;
    }
}

class Pro138476Answer {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        for (Integer key : list) {
            k -= map.get(key);
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}