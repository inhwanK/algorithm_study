package algorithm_study.programers.level2;

// JadenCase 문자열 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class Pro12951 {
    public String solution_1(String s) {
        String answer = "";

        boolean flag = true;
        String[] input = s.toLowerCase().split("");
        for(int i = 0; i < input.length; i++) {
            char[] arr = input[i].toCharArray();
            if(flag) {
                arr[0] = Character.toUpperCase(arr[0]);
                flag = false;
            }
            if(arr[0] == ' ') {
                flag = true;
            }

            String output = "";
            for(int j = 0; j < arr.length; j++) {
                output += arr[j];
            }
            input[i] = output;
        }
        for(int i = 0; i < input.length; i++) {
            answer += input[i];
        }
        return answer;
    }

    public String solution_2(String s) {
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
