package algorithm_study.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Flower Planting With No Adjacent - https://leetcode.com/problems/flower-planting-with-no-adjacent/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] answer = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i + 1, new ArrayList<>());
        }

        for (int[] path : paths) {
            map.get(path[0]).add(path[1]);
            map.get(path[1]).add(path[0]);
        }

        for (int garden : map.keySet()) {

            List<Integer> neighbor = map.get(garden);
            boolean[] neighborColors = new boolean[4];

            for (int neighborGarden : neighbor) {
                int colorNum = answer[neighborGarden - 1];
                if(colorNum != 0) {
                    neighborColors[colorNum - 1] = true;
                }
            }

            for (int i = 1; i <= neighborColors.length; i++) {
                if(!neighborColors[i - 1]) {
                    answer[garden - 1] = i;
                    break;
                }
            }
        }

        return answer;
    }



    public int[] gardenNoAdjRefactor(int n, int[][] paths) {
        int[] ans = new int[n];

        // 1) 인접 리스트(배열)로 가볍게
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int[] e : paths) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        // 2) 1..n 순회 + used[1..4]
        for (int i = 1; i <= n; i++) {
            boolean[] used = new boolean[5];
            for (int v : g[i]) {
                int c = ans[v - 1];
                if (c > 0) used[c] = true;
            }
            for (int c = 1; c <= 4; c++) {
                if (!used[c]) { ans[i - 1] = c; break; }
            }
        }
        return ans;
    }
}
