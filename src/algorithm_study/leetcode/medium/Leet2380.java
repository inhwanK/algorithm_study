package algorithm_study.leetcode.medium;

// 2380. Time Needed to Rearrange a Binary String - https://leetcode.com/problems/time-needed-to-rearrange-a-binary-string/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet2380 {
    public int secondsToRemoveOccurrences(String s) {
        // 시뮬레이션 할것인가?
        // 뭔가 수학적인 계산을 할 건가?
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCount++;
            }
        }

        int result = 0;
        while (true) {
            if (s.substring(0, oneCount).equals("1".repeat(oneCount))) {
                break;
            }

            s = s.replace("01", "10");
            result++;
        }
        return result;
    }

    public int secondsToRemoveOccurrences2(String s) {
        int zeros = 0;
        int time = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeros++;
            } else {
                if(zeros > 0) {
                    time = Math.max(time + 1, zeros);
                }
            }
        }
        return time;
    }
}
