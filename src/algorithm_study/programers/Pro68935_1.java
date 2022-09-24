package algorithm_study.programers;

import java.util.ArrayList;

// 3진법 뒤집기 - https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class Pro68935_1 {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        // 10진법 -> 3진법
        while (n != 0) {
            list.add(n % 3);
            n /= 3;
        }
        // 3진법 -> 10진법
        int tmp = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            answer += list.get(i) * tmp;
            tmp *= 3;
        }
        return answer;
    }
}

class Pro68935_2 {
    public int solution(int n) {
        int answer = 0;
        String ans = "";
        while (n != 0) {
            ans += n % 3;
            n /= 3;
        }
        return Integer.parseInt(ans, 3);
    }
}