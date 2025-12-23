package algorithm_study.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 1291. Sequential Digits - https://leetcode.com/problems/sequential-digits/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String target = "123456789";

        for (int len = 1; len <= 9; len++) {
            for (int i = 0; i + len <= 9; i++) {
                int t = Integer.parseInt(target.substring(i, i + len));
                if (t < low || t > high) {
                    continue;
                }
                result.add(t);
            }
        }

        return result;
    }
}
