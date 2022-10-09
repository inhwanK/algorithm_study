package algorithm_study.programers.level2;

// 최댓값과 최솟값 - https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class Pro12939 {
    public String solution(String s) {
        String[] input = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            min = Math.min(min, Integer.parseInt(input[i]));
            max = Math.max(max, Integer.parseInt(input[i]));
        }

        String answer = "";
        answer += min + " ";
        answer += max;
        return answer;
    }
}
