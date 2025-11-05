package algorithm_study.leetcode.medium;

import java.util.*;

// 826. Most Profit Assigning Work - https://leetcode.com/problems/most-profit-assigning-work/description/?envType=problem-list-v2&envId=vol6mrd1
public class Leet826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Map<Integer, Integer> map = new TreeMap();
        for(int i = 0; i < difficulty.length; i++) {
            if(map.containsKey(difficulty[i])) {
                map.put(difficulty[i], Math.max(map.get(difficulty[i]), profit[i]));
                continue;
            }
            map.put(difficulty[i], profit[i]);
        }

        TreeMap<Integer, Integer> dpMap = new TreeMap();
        int amount = 0;
        for(Integer diff : map.keySet()) {
            amount = Math.max(amount, map.get(diff));
            dpMap.put(diff, amount);
        }

        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            Map.Entry<Integer, Integer> entry = dpMap.floorEntry(worker[i]);
            if(entry != null) {
                result += entry.getValue();
            }
        }

        return result;
    }

    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // 1️⃣ (난이도, 수익)을 하나의 배열로 묶기
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // 2️⃣ 난이도 기준으로 오름차순 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 3️⃣ worker 배열도 오름차순 정렬
        Arrays.sort(worker);

        // 4️⃣ 결과 변수와 포인터 준비
        int res = 0;    // 전체 수익 합계
        int best = 0;   // 현재까지 가능한 최대 수익
        int i = 0;      // jobs 배열의 인덱스 포인터

        // 5️⃣ 각 worker에 대해 가능한 최대 수익 계산
        for (int w : worker) {
            // 현재 worker의 능력 w 이하인 모든 일(jobs[i][0])을 살피며
            // best(가능한 최대 수익)를 갱신
            while (i < n && jobs[i][0] <= w) {
                best = Math.max(best, jobs[i][1]);
                i++;
            }
            // 이제 이 worker가 할 수 있는 일 중 최대 수익을 합산
            res += best;
        }

        return res;
    }
}
