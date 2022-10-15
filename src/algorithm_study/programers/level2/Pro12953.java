package algorithm_study.programers.level2;

// N개의 최소공배수 - https://school.programmers.co.kr/learn/courses/30/lessons/12953
public class Pro12953 {
    public int solution(int[] arr) {
        int answer = arr[0];

        for(int i = 1; i < arr.length; i++) {
            answer = arr[i] * answer / gcd(answer, arr[i]);
        }

        return answer;
    }

    public int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}
