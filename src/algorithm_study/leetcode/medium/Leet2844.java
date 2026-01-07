package algorithm_study.leetcode.medium;

// 2844. Minimum Operations to Make a Special Number - https://leetcode.com/problems/minimum-operations-to-make-a-special-number/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2844 {
    public int minimumOperations(String num) {
        int n = num.length();
        int ans = n;

        ans = Math.min(ans, cost(num, '0', '0'));
        ans = Math.min(ans, cost(num, '2', '5'));
        ans = Math.min(ans, cost(num, '5', '0'));
        ans = Math.min(ans, cost(num, '7', '5'));

        if (num.indexOf('0') != -1) ans = Math.min(ans, n - 1);

        return ans;
    }

    private int cost(String s, char a, char b) {
        int n = s.length();

        // 뒤에서 b 찾기
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(j) != b) continue;

            // j 왼쪽에서 a 찾기
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == a) {
                    return (n - 1 - j) + (j - i - 1);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
