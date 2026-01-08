package algorithm_study.leetcode.medium;


// 869. Reordered Power of 2 - https://leetcode.com/problems/reordered-power-of-2/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet869 {
    public boolean reorderedPowerOf2(int n) {
        for (int x = 1; x > 0; x <<= 1) { // overflow까지
            if (check(x, n)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int a, int b) {
        if (digits(a) != digits(b)) return false;

        int[] count = new int[10];
        while (a > 0) {
            count[a % 10]++;
            a /= 10;
        }

        while (b > 0) {
            count[b % 10]--;
            b /= 10;
        }

        for (int v : count) {
            if (v != 0) {
                return false;
            }
        }
        return true;
    }

    private int digits(int a) {
        int count = 0;
        while (a > 0) {
            a /= 10;
            count++;
        }
        return count;
    }
}
