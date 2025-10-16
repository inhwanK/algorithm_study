package algorithm_study.leetcode.medium;

// Next Greater Element III - https://leetcode.com/problems/next-greater-element-iii/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet556 {
    public int nextGreaterElement(int n) {
        char[] d = String.valueOf(n).toCharArray();
        int m = d.length;

        int i = m - 2;
        while (i >= 0 && d[i] >= d[i + 1]) {
            i--;
        }
        if (i < 0) return -1;

        int j = m - 1;
        while (d[j] <= d[i]) j--;

        swap(d, i, j);

        reverse(d, i + 1, m - 1);

        long val = 0;
        for (char c : d) {
            val = val * 10 + (c - '0');
            if (val > Integer.MAX_VALUE) return -1;
        }
        return (int) val;
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private void reverse(char[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
}
