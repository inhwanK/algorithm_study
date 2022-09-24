package algorithm_study.programers;

// 최대공약수와 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12940
public class Pro12940 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        for (int i = 1; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                answer[0] = i;
            }
        }

        for (int i = max; i <= min * max; i++) {
            if (i % min == 0 && i % max == 0) {
                answer[1] = i;
                break;
            }
        }

        return answer;
    }

    public int[] solution_2(int n, int m) {
        int[] answer = new int[2];
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        answer[0] = gcd(max, min);
        answer[1] = max * min / answer[0];
        return answer;
    }

    int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

}

// 유클리드 호제법 사용하는 거임...
// https://velog.io/@geesuee/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B5%9C%EB%8C%80%EA%B3%B5%EC%95%BD%EC%88%98%EC%99%80-%EC%B5%9C%EB%8C%80%EA%B3%B5%EB%B0%B0%EC%88%98%EC%9E%90%EB%B0%94
class Pro12940Answer {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int big = Math.max(n, m);
        int small = Math.min(n, m);

        answer[0] = gcd(big, small);
        answer[1] = big * small / answer[0];

        return answer;
    }

    static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
