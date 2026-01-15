package algorithm_study.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

// 2280. Minimum Lines to Represent a Line Chart - https://leetcode.com/problems/minimum-lines-to-represent-a-line-chart/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2280 {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length <= 1) {
            return 0;
        }
        Arrays.sort(stockPrices, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] pre = stockPrices[0];
        int[] now = stockPrices[1];

        long preDy = stockPrices[1][1] - stockPrices[0][1];
        long preDx = stockPrices[1][0] - stockPrices[0][0];

        int result = 1;
        for (int i = 2; i < stockPrices.length; i++) {
            long dy = stockPrices[i][1] - stockPrices[i - 1][1];
            long dx = stockPrices[i][0] - stockPrices[i - 1][0];

            if (dx * preDy != dy * preDx) {
                result++;
            }

            preDx = dx;
            preDy = dy;
        }
        return result;
    }
}
