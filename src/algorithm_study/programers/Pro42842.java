package algorithm_study.programers;

// 카펫 - https://school.programmers.co.kr/learn/courses/30/lessons/42842
public class Pro42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow;
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int col = area / i;
                int row = i;

                if (yellow == (col - 2) * (row - 2)) {
                    answer[0] = col;
                    answer[1] = row;
                    break;
                }
            }
        }
        return answer;
    }
}
