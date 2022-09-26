package algorithm_study.programers.level1;

// 문자열 내 p와 y의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class Pro12916 {
    boolean solution(String s) {

        int countY = 0;
        int countP = 0;
        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (input == 'p' || input == 'P') {
                countY++;
            } else if (input == 'y' || input == 'Y') {
                countP++;
            }
        }

        if (countY == countP) return true;
        else return false;
    }
}
