package algorithm_study.leetcode.easy;

import java.util.*;

// 169. Majority Element - https://leetcode.com/problems/majority-element/?envType=study-plan&id=data-structure-ii
public class Leet169 {
    public int majorityElement(int[] nums) {

        // 사이즈가 n 인 배열이 주어진다.
        // the majority 요소를 반환해라
        // the majority 요소는 n / 2 번 이상 나타나는 요소이다.
        // 배열에 the majority 요소가 항상 존재한다고 가정한다.

        // Follow-up : 시간복잡도 O(n) 가능? 공간복잡도 O(1) 가능?

        HashMap<Integer, Integer> map = new HashMap();
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if(map.get(nums[i]) > nums.length / 2) {
                result = nums[i];
            }
        }
        return result;
    }
}
