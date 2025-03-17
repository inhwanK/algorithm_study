package algorithm_study.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 210. Course Schedule II - https://leetcode.com/problems/course-schedule-ii/
public class Leet210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        int[] ind = new int[numCourses];

        for (int[] node : prerequisites) {
            int pre = node[1];
            int course = node[0];
            list.get(pre).add(course);
            ind[course]++;
        }


        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] == 0) {
                que.add(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!que.isEmpty()) {
            int now = que.poll();
            result[index++] = now;
            for (int i = 0; i < list.get(now).size(); i++) {

                ind[list.get(now).get(i)]--;
                if (ind[list.get(now).get(i)] == 0) {
                    que.add(list.get(now).get(i));
                }
            }
        }


        return index == result.length ? result : new int[0];
    }
}
