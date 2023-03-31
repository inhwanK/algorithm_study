package algorithm_study.leetcode.easy;

// More Zeroes - https://leetcode.com/problems/move-zeroes/solutions/
public class Leet283 {
    public void moveZeroes(int[] nums) {
        // 0을 골라 젤 뒤로 보낸다.
        // 0
        int left = nums.length - 1;
        int right = nums.length - 1;
        while (left >= 0 && right >= 0) {
            if (nums[left] != 0) {
                left--;
                continue;
            }

            if (nums[right] == 0) {
                right--;
                continue;
            }

            if (right < left) {
                left = right - 1;
                continue;
            }

            for (int i = left; i < right; i++) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }

    // https://leetcode.com/problems/move-zeroes/solutions/172432/the-easiest-but-unusual-snowball-java-solution-beats-100-o-n-clear-explanation/
    public void moveZeroesAnswer(int[] nums) {
        int snowBallSize = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                snowBallSize++;
            }
            else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i]=0;
                nums[i-snowBallSize]=t;
            }
        }
    }
}
