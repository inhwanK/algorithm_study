package algorithm_study.programers.level2;

import java.util.*;
// 튜플 - https://school.programmers.co.kr/learn/courses/30/lessons/64065
public class Pro64065 {
    public int[] solution(String s) {

        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", " ");
        String[] input = s.split(" ");

        Arrays.sort(input, (a, b) -> {return Integer.compare(a.length(), b.length());});

        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < input.length; i++) {
            String[] target = input[i].split(",");
            for(int j = 0; j < target.length; j++) {
                int n = Integer.parseInt(target[j]);
                if(!list.contains(n)) {
                    list.add(n);
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public ArrayList<Integer> solution_answer(String s) {

        // 1. 튜플을 만들 ArrayList 객체.
        ArrayList<Integer> answer = new ArrayList<>();
        // 2. 가장 앞의 {{ 를 제거한다.
        s = s.substring(2, s.length());
        // 3. 가장 뒤의 }} 를 제거한 뒤, },{ 형태의 문자열을 -로 바꾼다.
        s = s.substring(0, s.length() - 2).replace("},{", "-");
        // 4. 위에서 바꾼 문자열을 기준으로 split 해준다.
        String str[] = s.split("-");
        // 5. 나눠진 문자열 배열을 길이에 따라 다시 정렬한다.
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {

                return Integer.compare(o1.length(), o2.length());
            }
        });

        // 6. 각 문자열을 탐색한다.
        for (String x : str) {
            // 7. 한 문자열마다 ,를 기준으로 split하여 새로운 문자열 배열을 만든다.
            String[] temp = x.split(",");
            // 8. 새로만든 문자열 배열에는 정수값만 존재하며 이를 탐색한다.
            for (int i = 0; i < temp.length; i++) {
                // 9. 각 문자열 값을 정수로 바꾼다.
                int n = Integer.parseInt(temp[i]);
                // 10. 튜플에 들어있는 값이 아니라면 추가해준다.
                if (!answer.contains(n))
                    answer.add(n);
            }
        }

        return answer;
    }
}
