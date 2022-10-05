package algorithm_study.programers.level1;

// 신규 아이디 추천 - https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class Pro72410 {
    public String solution(String new_id) {
        String answer = "";
        char[] arr = new_id.toLowerCase().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '_' || c == '-' || c == '.') {
                continue;
            }

            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                continue;
            }

            arr[i] = 0;
        }

        answer = new String(arr);
        answer = answer.replace("...", ".").replace("..", ".");

        if (answer.startsWith("."))
            answer = answer.substring(1);

        if (answer.endsWith("."))
            answer = answer.substring(0, answer.length() - 2);


        if (answer.equals(""))
            answer = "a";


        if (answer.length() >= 16) {
            answer = answer.substring(0, 16);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 2);
            }
        }


        while (new_id.length() <= 3) {
            answer += answer.charAt(new_id.length() - 1);
        }

        System.out.println(answer);

        return new_id;
    }
}
