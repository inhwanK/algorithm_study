package algorithm_study.programers.level3;

import java.util.*;
// [1차] 셔틀 버스 - https://school.programmers.co.kr/learn/courses/30/lessons/17678
public class Pro17678 {
    public String solution(int n, int t, int m, String[] timetable) {

        int[] crew = new int[timetable.length];

        for (int i = 0; i < timetable.length; i++) {
            String[] time = timetable[i].split(":");
            int totalMin = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            crew[i] = totalMin;
        }

        Arrays.sort(crew);

        // 2. 셔틀 도착 시각 계산 (09:00부터 n회 t분 간격)
        int[] shuttle = new int[n];
        shuttle[0] = 9 * 60; // 09:00
        for (int i = 1; i < n; i++) {
            shuttle[i] = shuttle[i - 1] + t;
        }

        int idx = 0;            // 현재 크루 인덱스
        int lastBoarded = -1;   // 마지막으로 탄 크루 시각

        // 3. 셔틀 운행 시뮬레이션
        for (int i = 0; i < n; i++) {
            int boarded = 0; // 이번 셔틀에 탄 인원 수

            while (boarded < m && idx < crew.length && crew[idx] <= shuttle[i]) {
                lastBoarded = crew[idx];
                boarded++;
                idx++;
            }

            // 4. 마지막 셔틀일 때 콘의 도착 시각 결정
            if (i == n - 1) {
                int answer;
                if (boarded < m) { // 자리가 남았으면
                    answer = shuttle[i];
                } else {            // 만석이면
                    answer = lastBoarded - 1;
                }
                return toHHMM(answer);
            }
        }

        return "error"; // 로직상 여기 안옴
    }

    // "HH:MM" → 분으로 변환
    static int toMin(String s) {
        String[] parts = s.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 분 → "HH:MM" 문자열
    static String toHHMM(int min) {
        int h = min / 60;
        int m = min % 60;
        return String.format("%02d:%02d", h, m);
    }
}
