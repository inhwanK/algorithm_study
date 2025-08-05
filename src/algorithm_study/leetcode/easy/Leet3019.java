package algorithm_study.leetcode.easy;

// 3019. Number of Changing Keys - https://leetcode.com/problems/number-of-changing-keys/description/
public class Leet3019 {
    public int countKeyChanges(String s) {
        String low = s.toLowerCase();
        int result = 0;
        for(int i = 0; i < low.length() - 1; i++) {
            if(low.charAt(i) != low.charAt(i + 1)) {
                result++;
            }
        }
        return result;
    }
}
