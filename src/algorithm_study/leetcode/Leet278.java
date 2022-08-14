package algorithm_study.leetcode;

public class Leet278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int index = (left + right) / 2;
        while (left <= right) {
            if (isBadVersion(index)) {
                right = index - 1;
            }
            if (!isBadVersion(index)) {
                left = index + 1;
            }
        }
    }

    public boolean isBadVersion(int n) {
        return false;
    }
}
