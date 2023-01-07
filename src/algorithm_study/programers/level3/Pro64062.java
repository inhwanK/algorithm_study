package algorithm_study.programers.level3;

// 징검다리 건너기 - https://school.programmers.co.kr/learn/courses/30/lessons/64062
public class Pro64062 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        // n + logn * n = O(nlogn);
        int min = 200000001;
        int max = 0;
        for (int i = 0; i < stones.length; i++) {
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }

        while (min != max) {

            int mid = (max + min) / 2;

            int bin = 0;
            int count = 0;

            for (int i = 0; i < stones.length; i++) {
                if (stones[i] - mid > 0) {
                    count = 0;
                    continue;
                }

                count++;
                bin = Math.max(bin, count);
            }

            if (bin >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}
