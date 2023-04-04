package algorithm_study.leetcode.medium;

import java.util.*;

// Merge Intervals - https://leetcode.com/problems/merge-intervals/description/?envType=study-plan&id=data-structure-ii
public class Leet56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        ArrayList<int[]> list = new ArrayList();
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                int[] target = {start, end};
                list.add(target);
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }

        int[] last = {start, end};
        list.add(last);

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
