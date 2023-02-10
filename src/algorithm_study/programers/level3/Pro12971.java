package algorithm_study.programers.level3;

// 스티커 모으기 (2) - https://school.programmers.co.kr/learn/courses/30/lessons/12971
public class Pro12971 {
    public int solution(int sticker[]) {

        if(sticker.length == 1) {
            return sticker[0];
        }

        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = dp[0];

        for(int i = 2; i < sticker.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        int answer = dp[sticker.length - 2];

        dp[0] = 0;
        dp[1] = sticker[1];

        for(int i = 2; i < sticker.length; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        return Math.max(answer, dp[sticker.length - 1]);
    }
}
