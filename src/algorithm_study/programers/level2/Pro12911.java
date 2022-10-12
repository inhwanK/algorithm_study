package algorithm_study.programers.level2;

// 다음 큰 숫자 - https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class Pro12911 {
    public int solution(int n) {
        int one = Integer.toBinaryString(n).replace("0", "").length();
        int two = 0;
        while (two != one) {
            n++;
            two = Integer.toBinaryString(n).replace("0", "").length();
        }
        return n;
    }
}
