package algorithm_study.programers.level3;

import java.util.*;

// 단속 카메라 - https://school.programmers.co.kr/learn/courses/30/lessons/42884
public class Pro42884 {
    public int solution(int[][] routes) {
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
}
