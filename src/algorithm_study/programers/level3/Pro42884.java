package algorithm_study.programers.level3;

import java.util.*;

// 단속 카메라 - https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class Pro42884 {
    public int solutionAnswer(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);

        int cam = -30001;
        for (int i = 0; i < routes.length; i++) {
            if (cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }
        return answer;
    }

    // 효율성에서 걸림
    public int solution(int[][] routes) {
        int answer = 0;

        // int left = 30000;
        // int right = -30000;

        Set<Integer> removed = new HashSet();
        Set<Integer> set = new HashSet();

        for (int i = 0; i < routes.length; i++) {
            int left = routes[i][0];
            int right = routes[i][1];
            for (int j = left; j <= right; j++) {
                set.add(j);
            }

            removed.add(i);
        }

        int routesCount = routes.length;

        while (!removed.isEmpty()) {

            List<Integer> pointList = getPointList(removed, routes, set);

            for (int i = 0; i < pointList.size(); i++) {
                removed.remove(pointList.get(i));
            }

            answer++;
        }

        return answer;
    }

    private List<Integer> getPointList(Set<Integer> removed, int[][] routes, Set<Integer> set) {

        Map<Integer, List<Integer>> camera = new HashMap();

        for (Integer index : set) {
            List<Integer> list = new ArrayList();

            for (int point = 0; point < routes.length; point++) {
                if (!removed.contains(point)) {
                    continue;
                }

                if (index >= routes[point][0] && index <= routes[point][1]) {
                    list.add(point);
                }
            }

            camera.put(index, list);
        }

        int maxPoint = 0;
        int result = -30001;
        for (Integer key : camera.keySet()) {
            if (maxPoint < camera.get(key).size()) {
                maxPoint = camera.get(key).size();
                result = key;
            }
        }

        return camera.get(result);
    }
}
