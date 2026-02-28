package algorithm_study.leetcode.medium;

// 2266. Count Number of Texts - https://leetcode.com/problems/count-number-of-texts/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2266 {
    static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();

        long[] dp3 = new long[n + 1];
        long[] dp4 = new long[n + 1];

        dp3[0] = dp4[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp3[i] = dp3[i - 1];
            if (i - 2 >= 0) dp3[i] = (dp3[i] + dp3[i - 2]) % MOD;
            if (i - 3 >= 0) dp3[i] = (dp3[i] + dp3[i - 3]) % MOD;

            dp4[i] = dp4[i - 1];
            if(i - 2 >= 0) dp4[i] = (dp4[i] + dp4[i - 2]) % MOD;
            if(i - 3 >= 0) dp4[i] = (dp4[i] + dp4[i - 3]) % MOD;
            if(i - 4 >= 0) dp4[i] = (dp4[i] + dp4[i - 4]) % MOD;
        }

        long ans = 1;
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                cnt++;
            } else {
                char key = pressedKeys.charAt(i - 1);
                ans = ans * ((key == '7' || key == '9') ? dp4[cnt] : dp3[cnt]) % MOD;
                cnt = 1;
            }
        }

        char key = pressedKeys.charAt(n - 1);
        ans = ans * ((key == '7' || key == '9') ? dp4[cnt] : dp3[cnt]) % MOD;

        return (int) ans;
    }
}
