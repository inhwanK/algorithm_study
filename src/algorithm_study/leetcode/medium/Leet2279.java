package algorithm_study.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

// 2279. Maximum Bags With Full Capacity of Rocks - https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // rocks.length만큼 반복
        // 현재 full인 bag count

        // capacity[i] - rocks[i] 한 값을 키로하는 TreeMap 생성
        // 수가 작은 것부터 정렬되어 있으므로
        // add 값에 맵의 key 값만큼 곱해서 빼기

        Map<Integer, Integer> map = new TreeMap<>();
        int result = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] == capacity[i]) {
                result++;
                continue;
            }
            int amount = capacity[i] - rocks[i];
            map.put(amount, map.getOrDefault(amount, 0) + 1);
        }

        for (Integer amount : map.keySet()) {
            if (amount * map.get(amount) <= additionalRocks) {
                additionalRocks -= amount * map.get(amount);
                result += map.get(amount);
                continue;
            }

            int value = additionalRocks / amount;
            result += value;
            additionalRocks -= value * amount;
        }
        return result;
    }
}

