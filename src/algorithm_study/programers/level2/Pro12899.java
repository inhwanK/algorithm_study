package algorithm_study.programers.level2;


// 124 나라의 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12899
public class Pro12899 {
    public String solution(int n) {
        String answer = "";

        String[] nara = {"4", "1", "2"};

        int index = 0;
        while (n > 0) {
            index = n % 3;

            n /= 3;
            answer = nara[index] + answer;
            if (index == 0) {
                n--;
            }
        }

        return answer;
    }
}
