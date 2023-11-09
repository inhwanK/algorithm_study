package algorithm_study.programers.level2;

// 숫자 카드 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/135807
public class Pro135807 {
    public boolean notDivisible(int[] arr, int num) {
        for (int n : arr)
            if (n % num == 0)
                return false;
        return true;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {
        // 0. 입력 및 초기화
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        // 1. 각 배열의 최대공약수 구하기
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 2. 서로의 배열을 나눌 수 없는지 확인
        if (notDivisible(arrayB, gcdA))
            if (answer < gcdA)
                answer = gcdA;

        if (notDivisible(arrayA, gcdB))
            if (answer < gcdB)
                answer = gcdB;

        // 3. 최댓값 반환
        return answer;
    }
}

class Pro135807_2 {
    // 유클리드 호제법
    // every 메서드도 사용해보기?

    // 가장 큰 양의 정수 a 값 구하는 것인데...
    // 두 조건을 만족하는 것이 최대 공약수가 아닐 수도 있는데
    // 유클리드 호제법 사용하는게 맞나?

    // 아래 링크를 보면 맞음..
    // https://school.programmers.co.kr/questions/40997
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int divA = 0;
        int divB = 0;
        for (int i = arrayA.length - 1; i >= 0; i--) {
            divA = gcd(divA, arrayA[i]);
            divB = gcd(divB, arrayB[i]);
        }

        int AA = divA;
        int BB = divB;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayB[i] % divA == 0) {
                AA = 0;
            }

            if (arrayA[i] % divB == 0) {
                BB = 0;
            }
        }

        return Math.max(AA, BB);
    }


    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
}