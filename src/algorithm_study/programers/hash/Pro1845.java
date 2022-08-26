package algorithm_study.programers.hash;

import java.util.*;

// 폰켄몬 - https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Pro1845 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        answer = Math.min(set.size(), nums.length / 2);

        return answer;
    }
}
