package algorithm_study.codility;

public class TapeEquilibrium {
    public int solution(int[] A) {

        int min = 100001;
        for (int i = 0; i < A.length; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < i; j++) {
                a += A[j];
            }

            for (int j = i; j < A.length; j++) {
                b += A[j];
            }

            min = Math.min(Math.abs(a - b), min);
        }
        return min;
    }
}
