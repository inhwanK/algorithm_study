package algorithm_study.programers.level2;

// 연속된 부분 수열의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/178870
public class Pro178870 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = sequence.length - 1;
        int right = sequence.length - 1;
        int sum = sequence[sequence.length - 1];

        int length = Integer.MAX_VALUE;
        while (left >= 0) {
            if (left == 0 && sum < k) {
                break;
            }

            if (sum > k) {
                sum -= sequence[right];
                right--;
            } else if (sum < k) {
                left--;
                sum += sequence[left];
            } else {
                if (length >= right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    length = right - left;
                }

                if (left == 0) {
                    break;
                }

                left--;
                sum += sequence[left];
                sum -= sequence[right];
                right--;
            }
        }

        return answer;
    }
}
