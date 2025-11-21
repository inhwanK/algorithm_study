package algorithm_study.leetcode.medium;

import java.util.*;

// 825. Friends Of Appropriate Ages - https://leetcode.com/problems/friends-of-appropriate-ages/description/?envType=problem-list-v2&envId=vtle2y3r
public class Leet825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int age = ages[i];
            if (age < 15) continue;

            while (ages[left] <= age / 2 + 7) {
                left++;
            }

            while (right + 1 < n && ages[right + 1] <= age) {
                right++;
            }

            result += right - left;
        }

        return result;
    }
}
