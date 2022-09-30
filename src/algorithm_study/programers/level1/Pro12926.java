package algorithm_study.programers.level1;

// 시저 암호 - https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class Pro12926 {
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == ' ') {
                answer += " ";
            } else {

                if (Character.isUpperCase(target)) {
                    if (target + n > 'Z') {
                        target = (char) (target + n - 'Z' - 1 + 'A');
                    } else {
                        target = (char) (target + n);
                    }
                } else {
                    if (target + n > 'z') {
                        target = (char) (target + n - 'z' - 1 + 'a');
                    } else {
                        target = (char) (target + n);
                    }
                }
                answer += target;
            }
        }

        return answer;
    }

    public String solution_1(String s, int n) {
        String result = "";
        n = n % 26;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            } else if(Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            }
            result += ch;
        }
        return result;
    }

    public String solution_answer(String s, int n) {
        String result = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            result += ch;
        }
        return result;
    }
}
