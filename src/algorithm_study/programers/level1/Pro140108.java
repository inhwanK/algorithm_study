package algorithm_study.programers.level1;

// 문자열 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class Pro140108 {
    public int solution(String s) {
        int answer = 0;

        char[] arr = s.toCharArray();
        char target = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                answer++;
                target = arr[i];
                count++;
                continue;
            }

            if (target == arr[i]) {
                count++;
                continue;
            }

            count--;
        }

        if (count >= 0) {
            answer++;
        }
        return answer;
    }
}
