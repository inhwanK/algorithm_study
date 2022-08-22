package algorithm_study.leetcode.leetcode75;

import java.util.*;

// Is Subsequence - https://leetcode.com/problems/is-subsequence/
public class Leet392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;

        boolean[] visited = new boolean[s.length()];
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            while (pre != t.length()) {
                if (t.charAt(pre) == target) {
                    visited[i] = true;
                    pre++;
                    break;
                }
                pre++;
            }
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}

class Leet392FollowUp {
    public boolean isSubsequence(String s, String t) {
        // step 1: save all the index for the t
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                List<Integer> pos = new ArrayList<>();
                pos.add(i);
                map.put(c, pos);
            } else {
                List<Integer> pos = map.get(c);
                pos.add(i);
//                    map.put(c, pos);
            }
        }

        // step 2: for each char in s, find the first index
        int prevIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> pos = map.get(c);
            if (pos == null || pos.size() == 0) {
                return false;
            }

            int currentIndex = getNextIndexGreaterThanTarget(pos, prevIndex);

            if (currentIndex == -1) {
                return false;
            }

            prevIndex = currentIndex;
        }

        return true;
    }

    // find next number greater than target
    // if not found, return -1
    private int getNextIndexGreaterThanTarget(List<Integer> pos, int targetIndex) {
        int lo = 0;
        int hi = pos.size() - 1;

        while (lo + 1 <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (pos.get(mid) == targetIndex) {
                lo = mid + 1;
            } else if (pos.get(mid) > targetIndex) {
                hi = mid;
            } else if (pos.get(mid) < targetIndex) {
                lo = mid + 1;
            }
        }

        if (pos.get(lo) > targetIndex) {
            return pos.get(lo);
        }

        if (pos.get(hi) > targetIndex) {
            return pos.get(hi);
        }

        return -1;
    }
}