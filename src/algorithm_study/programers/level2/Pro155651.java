package algorithm_study.programers.level2;

import java.util.*;

// 호텔 대실 - https://school.programmers.co.kr/learn/courses/30/lessons/155651
public class Pro155651 {
    public int solution(String[][] book_time) {
        int answer = 0;

        ArrayList<Time> list = new ArrayList();

        for (int i = 0; i < book_time.length; i++) {

            int end = parse(book_time[i][1]) + 10 >= 24 * 60 ? 24 * 60 - 1 : parse(book_time[i][1]) + 10;
            int start = parse(book_time[i][0]);

            Time time = new Time(start, end);
            list.add(time);
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int now = 0;
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).end > list.get(j).start) {
                    now++;
                }
            }

            answer = Math.max(answer, now);
        }
        return answer;
    }

    class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Time o) {
            return this.end - o.end;
        }
    }

    private int parse(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
}

class Pro155651Answer {
    public int solution(String[][] book_time) {

        int[][] bkt = new int[book_time.length][];

        for (int i = 0; i < book_time.length; i++) {
            bkt[i] = new int[]{parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10};
        }

        Arrays.sort(bkt, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;

        for (int i = 0; i < bkt.length; i++) {
            while (!que.isEmpty() && que.peek()[1] <= bkt[i][0]) {
                que.poll();
            }
            que.add(bkt[i]);
            ans = Math.max(ans, que.size());
        }

        return ans;
    }

    protected int parseTime(String time) {

        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;

    }
}
