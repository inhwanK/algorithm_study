package algorithm_study.programers.level2;

// 점프와 순간 이동 - https://school.programmers.co.kr/learn/courses/30/lessons/12980
public class Pro12980 {
    public int solution(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                count++;
                n--;
            }
        }
        return count;
    }
}
