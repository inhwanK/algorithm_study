package algorithm_study.programers.level2;

import java.util.*;

// 시소 짝꿍 - https://school.programmers.co.kr/learn/courses/30/lessons/152996
public class Pro152996 {
    public static long solution(int[] weights) {
        long answer = 0;

        // 중심으로부터 2,3,4 거리
        // 탑승한 사람의 무게와 좌석간 거리의 곱이 같으면 시소 짝꿍

        // 같은 쌍일 경우 세지 않아야 함.

        int[][] wd = new int[weights.length][4];

        HashSet<String> set = new HashSet();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();

        for (int i = 0; i < weights.length; i++) {
            wd[i][0] = weights[i];
            for (int j = 2; j < 5; j++) {
                wd[i][j - 1] = weights[i] * j;
                if (map.containsKey(wd[i][j - 1])) {
                    ArrayList<Integer> list = map.get(wd[i][j - 1]);

                    // for(int k = 0; k < list.size(); k++) {
                    //     set.add(list.get(k) + ":" + weights[i]);
                    //     set.add(weights[i] + ":" + list.get(k));
                    // }
                    list.add(weights[i]);
                } else {
                    ArrayList<Integer> nList = new ArrayList<>();
                    nList.add(weights[i]);
                    map.put(wd[i][j - 1], nList);
                    // map.get(wd[i][j - 1]).add(weights[i]);
                }
            }
            System.out.println(map.size());
        }

        return answer;
    }
}
