package algorithm_study.leetcode.medium;

import java.util.*;

// 204. Count Primes - https://leetcode.com/problems/count-primes/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet204 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean p : isPrime) {
            if (p) count++;
        }
        return count;
    }
}
