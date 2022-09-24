package algorithm_study.programers;

import java.util.Arrays;

// 소수 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12977
public class Pro12977 {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public boolean isPrime(int sum) {
        for (int prime = 2; prime <= Math.sqrt(sum); prime++) {
            if(sum % prime == 0) {
                return false;
            }
        }
        return true;
    }

}
