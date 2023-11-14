package algorithm_study.programers.level1;

// 옹알이 (2) - https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class Pro133499 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") || babbling[i].contains("mama") || babbling[i].contains("woowoo") || babbling[i].contains("yeye")) {
                continue;
            }

            for (int j = 0; j < 4; j++) {
                babbling[i] = babbling[i].replace(str[j], " ");
            }

            babbling[i] = babbling[i].replace(" ", "");
            if (babbling[i].equals("")) {
                answer++;
            }

        }
        return answer;
    }
}
