package algorithm_study.leetcode.algorithm;

// 이분 탐색 자꾸 헷갈려서 안되겠음... 따로 책보고 다시 공부 필요...
// First Bad Version - https://leetcode.com/problems/first-bad-version/
public class Leet278 {
    public int firstBadVersion(int n) {
        if (n <= 0 || !isBadVersion(n)) {
            return -1;
        }
        // If first version is a bad version, then all versions are bad.
        if (isBadVersion(1)) {
            return 1;
        }

        int left = 1;
        int right = n;
        int now = 0;
        while (left < right) {
            now = left + (right - left) / 2;
            if (isBadVersion(now)) {
                right = now;
            } else {
                left = now + 1;
            }

        }
        return left;
    }

    // 더미 함수
    public boolean isBadVersion(int n) {
        return false;
    }
}
