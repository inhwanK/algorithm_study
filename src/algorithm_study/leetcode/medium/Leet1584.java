package algorithm_study.leetcode.medium;

import java.util.Arrays;

// 1584. Min Cost to Connect All Points - https://leetcode.com/problems/min-cost-to-connect-all-points/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1584 {
    public int minCostConnectPoints(int[][] points) {
        // MST에 포함되는 것과 그렇지 않은 것 사이의 거리를 구하기
        boolean[] inMST = new boolean[points.length];
        int[] dist = new int[points.length];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        int result = 0;

        for (int i = 0; i < points.length; i++) {


            int index = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < points.length; j++) {
                if (!inMST[j] && min > dist[j]) {
                    min = dist[j];
                    index = j;
                }
            }

            inMST[index] = true;
            result += min;

            for (int v = 0; v < points.length; v++) {
                if (!inMST[v]) {
                    int cost = manhattan(points[index], points[v]);

                    if (cost < dist[v]) {
                        dist[v] = cost;
                    }
                }
            }
        }

        return result;
    }

    private int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
