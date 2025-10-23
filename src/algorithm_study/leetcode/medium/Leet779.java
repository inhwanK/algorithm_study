package algorithm_study.leetcode.medium;

// 779. K-th Symbol in Grammar - https://leetcode.com/problems/k-th-symbol-in-grammar/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet779 {

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int parent = kthGrammar(n - 1, (k + 1) / 2);

        if (k % 2 == 1) {
            return parent;
        } else {
            return 1 - parent;
        }
    }
}
