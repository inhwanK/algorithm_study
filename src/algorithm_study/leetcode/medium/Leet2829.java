package algorithm_study.leetcode.medium;

// 2829. Determine the Minimum Sum of a k-avoiding Array - https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2829 {
    public int minimumSum(int n, int k) {
        // 정의를 해보자.
        // 배열을 하나 완성해야해.
        // 그 배열에서 서로 다른 숫자 두개를 뽑았을때,
        // 그 두개의 합이 k가 되지 않는 배열

        // 합해서 k가 될 수 있는 조합을 선택하고, 그 중 작은 것들만 고르고, 큰 것들은 안고르면 어때?

        // k = 4인 경우 1 : 3, 2 : 2

        // 방향은 맞음

        int sum = 0;
        int val = 1;
        int index = 1;
        while (index <= n) {

            if (val > k / 2 && val < k) {
                val++;
                continue;
            }

            sum += val;
            val++;
            index++;
        }

        return sum;
    }
}
