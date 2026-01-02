package algorithm_study.leetcode.medium;

// 3335. Total Characters in String After Transformations I - https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet3335 {
    static final long MOD = 1_000_000_007L;

    public int lengthAfterTransformations(String s, int t) {
        long[] v = new long[26];
        for (int i = 0; i < s.length(); i++) v[s.charAt(i) - 'a']++;

        long[][] M = trans();              // 1-step 전이
        long[][] P = pow(M, t);            // t-step 전이
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            long sum = 0;
            for (int j = 0; j < 26; j++) sum = (sum + P[i][j] * v[j]) % MOD;
            ans = (ans + sum) % MOD;
        }
        return (int) ans;
    }

    static long[][] trans() {
        long[][] m = new long[26][26];
        for (int i = 0; i < 25; i++) m[i + 1][i] = 1; // a->b ... y->z
        m[0][25] = 1;  // z->a
        m[1][25] = 1;  // z->b
        return m;
    }

    static long[][] pow(long[][] a, int e) {
        long[][] r = new long[26][26];
        for (int i = 0; i < 26; i++) r[i][i] = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = mul(r, a);
            a = mul(a, a);
            e >>= 1;
        }
        return r;
    }

    static long[][] mul(long[][] A, long[][] B) {
        long[][] C = new long[26][26];
        for (int i = 0; i < 26; i++)
            for (int k = 0; k < 26; k++)
                if (A[i][k] != 0)
                    for (int j = 0; j < 26; j++)
                        if (B[k][j] != 0)
                            C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
        return C;
    }
}
