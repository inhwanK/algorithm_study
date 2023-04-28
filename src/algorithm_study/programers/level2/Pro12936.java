package algorithm_study.programers.level2;

import java.util.*;

// 줄 서는 방법 - https://school.programmers.co.kr/learn/courses/30/lessons/12936
public class Pro12936 {
    // 1. k 를 n - 1으로 나눈다.
    // 2. (나눈 값 + 1) 해당 인덱스에 넣는다. 남아있는 수 중 최솟값 기준으로?
    // 3. 나머지를 다시 k 값으로 바꾼다.
    // 4. 인덱스에 1을 더한다.
    // 5. n 에다가 1을 뺀다.
    // 6. 몫이 0일 때까지 || n이 1일 때까지 1 ~ 5를 반복한다.
    // 7. 몫이 0이면 나머지만큼 반복문을 돌린다.

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long fac = 1;
        int index = 0;

        ArrayList<Integer> list = new ArrayList();
        for (int i = 1; i <= n; i++) {
            fac *= i;
            list.add(i);
        }

        k--;
        while (n > 0) {
            fac /= n;
            answer[index] = list.get((int) (k / fac));
            list.remove((int) (k / fac));

            k %= fac;
            n--;
            index++;
        }

        return answer;
    }
}
