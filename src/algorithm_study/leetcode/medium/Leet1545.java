package algorithm_study.leetcode.medium;

// 1545. Find Kth Bit in Nth Binary String - ems/find-kth-bit-in-nth-binary-string/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet1545 {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int mid = (int) Math.pow(2, n - 1);
        if (k == mid) {
            return '1';
        }

        if (k > mid) {
            char c = findKthBit(n - 1, mid * 2 - k);
            return c == '0' ? '1' : '0';
        } else {
            return findKthBit(n - 1, k);
        }
    }
}
