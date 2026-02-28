package algorithm_study.leetcode.medium;

// 2266. Count Number of Texts - https://leetcode.com/problems/count-number-of-texts/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2266 {
    public int countTexts(String pressedKeys) {
        int MOD = 1000000007;
        int n = pressedKeys.length();

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (pressedKeys.charAt(i) != pressedKeys.charAt(i - 1)) {
                count++;
            }
        }

        // 2222 3-4
        // aaaa, aab, ac, aba, baa, bb, ca 4-6
        // aaaaa, aaab, aac, aaba, abaa, abb, aca, baaa, bab, bba, caa, cb, bc 5-13
        return 0;
    }
}
