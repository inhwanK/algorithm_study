package algorithm_study.leetcode.medium;

import java.util.*;

// Top K Frequent Elements - https://leetcode.com/problems/top-k-frequent-elements/description/
public class Leet347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[k];

        int max = -10001;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(map.get(nums[i]), max);
        }

        int index = 0;
        while (k > 0) {
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                if (map.get(key) == max) {
                    result[index] = key;
                    k--;
                    index++;

                }
            }
            max--;
        }

        return result;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // Step 1: Count the frequency of each element
        Map<Integer, Integer> h = new HashMap<>();              // num:count
        for (int num : nums)
            h.put(num, h.getOrDefault(num, 0) + 1);

        // Step 2: Create buckets (arr) where index represents count
        List<Integer>[] arr = new ArrayList[nums.length + 1];     //Can't have more size than the length of nums +1 (if all elements are same)
        for (int num : h.keySet())                                //count->   [0 1 2 3 ....]
        {                                                       //num->     [  3 2 1 ....]
            int count = h.get(num);
            if (arr[count] == null)                               //index is the count
                arr[count] = new ArrayList<>();
            arr[count].add(num);                                //Add num to bucket at the index corresponding to its count
        }

        // Step 3: Gather the top k frequent elements
        int[] res = new int[k];
        int j = 0;
        for (int i = arr.length - 1; i >= 0 && j < k; i--)              // Traverse from highest count to low
        {
            if (arr[i] != null) {
                for (int num : arr[i]) {
                    res[j] = num;
                    j++;
                }
            }
        }
        return res;
    }
}
