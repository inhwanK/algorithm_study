package algorithm_study.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Find K Closest Elements - https://leetcode.com/problems/find-k-closest-elements/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= k) {
            int min = Math.abs(arr[left] - x);
            int max = Math.abs(arr[right] - x);

            if (min <= max) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
