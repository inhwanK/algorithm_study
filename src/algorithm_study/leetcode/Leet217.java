package algorithm_study.leetcode;

import java.util.*;

public class Leet217 {
    // 시간 복잡도 O(NlogN)
    // Arrays.sort()는 듀얼 피봇 방식 이는 시간복잡도 nlogn 최악의 경우 n^2
    // 반복문은 O(n) 이라서 정렬의 시간복잡도가 더 크기 때문에
    // 정렬 시간복잡도로 계산한다.
    // Collection.sort() 와 최악의 경우 시간복잡도가 다르다. nlogn
    // OS 강의에서 배운 참조 지역성 때문에 생기는 차이라고 한다.
    // 참고 블로그 - https://laugh4mile.tistory.com/175
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}

class Leet217Solution {
    public boolean containsDuplicate(int[] nums) {
        // 시간 복잡도 O(N) 대신에 메모리가 많이 들지만
        // 보통 시간복잡도를 기준으로 보는 경우가 많음 ㅎㅎㅎ
        final Set<Integer> distinct = new HashSet<Integer>();
        for (int num : nums) {
            if (distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }
}
