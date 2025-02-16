package algorithm_study.leetcode.medium;

import java.util.*;

//  Group Anagrams - https://leetcode.com/problems/group-anagrams/
public class Leet49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);

            String sortedKey = new String(arr);

            map.putIfAbsent(sortedKey, new ArrayList());
            map.get(sortedKey).add(strs[i]);
        }

        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();

            int[] count = new int[26];
            for (int j = 0; j < arr.length; j++) {
                count[arr[j] - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append(",");
            }
            String sortedKey = sb.toString();
            map.putIfAbsent(sortedKey, new ArrayList());
            map.get(sortedKey).add(strs[i]);
        }

        return new ArrayList(map.values());
    }
}
