package algorithm_study.programers.level1;

// 문자열 다루기 기본 - https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class Pro12918 {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i);
            if (temp < 48 || temp > 58) {
                return false;
            }
        }

        return answer;
    }

    // 좋은 풀이
    public boolean solution_1(String s) {

        if (s.length() == 4 || s.length() == 6) {

            try {
                int x = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }

        } else return false;
    }

    // 정규표현식 사용 풀이
    public boolean solution_2(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }
}
