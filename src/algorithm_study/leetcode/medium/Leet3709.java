package algorithm_study.leetcode.medium;

import java.util.*;

// 3709 Design Exam Scores Tracker - https://leetcode.com/problems/design-exam-scores-tracker/submissions/1804164250/?envType=problem-list-v2&envId=vol6mrd1
public class Leet3709 {
    List<long[]> records = new ArrayList();
    long preScore = 0;
    int left = 0;
    int right = 0;

    public void record(int time, int score) {
        records.add(new long[]{time, preScore + score});
        preScore += score;
    }

    // [startTime, endTime] 포함 범위 합
    public long totalScore(int startTime, int endTime) {
        if (records.isEmpty()) return 0L;

        int l = lowerBound(startTime); // time >= startTime 인 첫 인덱스
        int r = upperBound(endTime);   // time >  endTime 인 첫 인덱스

        if (l >= r) return 0L;         // 범위 내 기록 없음

        long rightSum = records.get(r - 1)[1];         // prefix(r-1)
        long leftSum = (l == 0) ? 0L : records.get(l - 1)[1]; // prefix(l-1)
        return rightSum - leftSum;
    }

    // ----- helpers -----

    private int lowerBound(int t) { // 첫 time >= t
        int lo = 0, hi = records.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (records.get(mid)[0] >= t) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private int upperBound(int t) { // 첫 time > t
        int lo = 0, hi = records.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (records.get(mid)[0] > t) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
