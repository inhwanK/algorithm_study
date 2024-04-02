package algorithm_study.programers.level1;

import java.util.*;

// 개인정보 수집 유효기간 - https://school.programmers.co.kr/learn/courses/30/lessons/150370
public class Pro150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        HashMap<String, Integer> termsMap = new HashMap();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }

        ArrayList<Integer> result = new ArrayList();
        Date to = new Date(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            Date now = new Date(privacy[0]);
            now.calc(termsMap.get(privacy[1]));

            if (!to.compare(now)) {
                result.add(i + 1);
            }
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    class Date {
        int date;

        public Date(String date) {
            String[] d = date.split("\\.");
            int year = Integer.parseInt(d[0]);
            int month = Integer.parseInt(d[1]);
            int day = Integer.parseInt(d[2]);

            this.date = (year * 12 * 28) + (month * 28) + day;
        }

        public boolean compare(Date o) {
            if (this.date >= o.date) {
                return false;
            }
            return true;
        }

        public void calc(int mon) {
            this.date = this.date + (mon * 28);
        }
    }
}
