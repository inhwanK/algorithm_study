package algorithm_study.programers.level1;

// 크기가 작은 부분 문자열 - https://school.programmers.co.kr/learn/courses/30/lessons/147355
public class Pro147355 {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {

            String target = t.substring(i, p.length() + i);
            if (Long.parseLong(target) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}
