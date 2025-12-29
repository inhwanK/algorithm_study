package algorithm_study.leetcode.medium;

// 3192. Minimum Operations to Make Binary Array Elements Equal to One II - https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet3192 {
    public int minOperations(int[] nums) {
        int operations = 0;     // 실제로 flip을 수행한 횟수
        boolean flipped = false; // 지금까지 flip을 홀수번 했으면 true (즉, 뒤집힌 상태)

        for (int i = 0; i < nums.length; i++) {

            // 1) 현재 nums[i]가 "실제로 보이는 값"이 뭔지 계산한다.
            // flipped == false : 지금까지 뒤집은 적이 없거나 짝수번 → 값 그대로
            // flipped == true  : 홀수번 뒤집힘 → 값이 반대로 보임
            int current;
            if (!flipped) {
                current = nums[i];
            } else {
                // 뒤집힌 상태면 0->1, 1->0
                current = (nums[i] == 0) ? 1 : 0;
            }

            // 2) 목표는 모든 값을 1로 만드는 것.
            // 현재 위치 i에서 current가 0이라면?
            // - i보다 오른쪽에서 flip해도 i는 안 바뀜(연산이 i~끝이기 때문)
            // - 그러므로 i를 1로 만들 수 있는 "유일한 기회"는 지금 i에서 flip하는 것
            if (current == 0) {
                operations++;        // i에서 flip을 수행
                flipped = !flipped;  // flip을 한 번 더 했으니 상태가 토글됨 (짝<->홀)
            }
        }

        return operations;
    }
}
