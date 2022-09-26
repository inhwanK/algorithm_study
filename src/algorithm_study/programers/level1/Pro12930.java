package algorithm_study.programers.level1;

// 다양한 예외케이스를 고려해야함 인환아...
// 빈 문자열("")로 split 사용하는것도 기억하자
// 이상한 문자만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class Pro12930 {
    public String solution(String s) {
        String answer = "";

        String[] input = s.split("");
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].contains(" ")) {
                count = 0;
                continue;
            }

            if (count % 2 == 0) {
                input[i] = input[i].toUpperCase();
            } else {
                input[i] = input[i].toLowerCase();
            }
            count++;
        }

        for (int i = 0; i < input.length; i++) {
            answer += input[i];
        }

        return answer;
    }

    public String solutionAnswer(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for (String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }
}
