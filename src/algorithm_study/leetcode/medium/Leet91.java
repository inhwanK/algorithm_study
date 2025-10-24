package algorithm_study.leetcode.medium;

// 91. Decode Ways - https://leetcode.com/problems/decode-ways/description/
public class Leet91 {
    public int numDecodings(String s) {
        char[] code = s.toCharArray();

        int size = s.length();
        int left = 0;
        int[] dp = new int[size + 1];
        dp[0] = 1;

        while (left < size + 1) {
            if (dp[left] == 0) {
                left++;
                continue;
            }

            if (valid1(left, code)) {
                dp[left + 1] += dp[left];
            }
            if (valid2(left, code)) {
                dp[left + 2] += dp[left];
            }
            left++;
        }

        return dp[size];
    }

    private boolean valid1(int index, char[] code) {
        if (index >= code.length) {
            return false;
        }
        if (code[index] == '0') {
            return false;
        }
        return true;
    }

    private boolean valid2(int index, char[] code) {
        if (index + 1 >= code.length || code[index] == '0') {
            return false;
        }
        int target = Integer.parseInt(String.valueOf(code[index]) + String.valueOf(code[index + 1]));
        if (target > 26) {
            return false;
        }
        return true;
    }
}
