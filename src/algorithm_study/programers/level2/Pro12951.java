package algorithm_study.programers.level2;

// JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Pro12951 {
    public String solution(String s) {
        String answer = "";

        StringBuffer sb = new StringBuffer();
        s = s.toLowerCase();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ' ') sb.append(" ");
            else if (s.charAt(i - 1) == ' ')
                sb.append(Character.toUpperCase(s.charAt(i)));
            else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String solutionAnswer(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
    }
}
