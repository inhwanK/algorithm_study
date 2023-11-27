package algorithm_study.programers.level1;

// 숫자 짝꿍 - https://school.programmers.co.kr/learn/courses/30/lessons/131128
// 일반 String을 사용할 경우 시간 초과,
// StringBuilder의 경우 mutable 클래스, 즉 가변 클래스로 문자열을 동적으로 변경할 수 있음 (StringBuffer) 도 마찬가지
// 따라서 문자열 연산에서 StringBuilder, StringBuffer 가 훨씬 유리함.
public class Pro131128 {
    public String solution(String X, String Y) {
        String answer = "";

        int[] xa = new int[10];
        int[] ya = new int[10];

        // 3,000,000
        for(int i = 0; i < X.length(); i++) {
            xa[X.charAt(i) - '0']++;
        }
        // 3,000,000
        for(int i = 0; i < Y.length(); i++) {
            ya[Y.charAt(i) - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        // 10 * 3,000,000
        for(int i = 9; i >= 0; i--) {
            int count = Math.min(xa[i], ya[i]);

            // 3,000,000
            for(int j = 0; j < count; j++) {
                sb.append(i);
            }
        }

        answer = sb.toString();
        if(answer.equals("")) {
            return "-1";
        } else if(answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
