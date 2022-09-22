package algorithm_study.programers.kakao;
import java.util.*;

// 2022 카카오 성격유형 검사하기
public class Pro118666 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap();
        int[] result = new int[4];
        for(int i = 0; i < survey.length; i++) {
            map.put(survey[i], choices[i]);

            if(choices[i] == 4) {
                continue;
            }

            if(survey[i].equals("RT")) {
                result[0] += choices[i] - 4;
            }

            if(survey[i].equals("TR")) {
                result[0] += 4 - choices[i];
            }

            if(survey[i].equals("CF")) {
                result[1] += choices[i] - 4;
            }

            if(survey[i].equals("FC")) {
                result[1] += 4 - choices[i];
            }

            if(survey[i].equals("JM")) {
                result[2] += choices[i] - 4;
            }

            if(survey[i].equals("MJ")) {
                result[2] += 4 - choices[i];
            }

            if(survey[i].equals("AN")) {
                result[3] += choices[i] - 4;
            }

            if(survey[i].equals("NA")) {
                result[3] += 4 - choices[i];
            }

        }

        if(result[0] <= 0) {
            answer += 'R';
        } else {
            answer += 'T';
        }

        if(result[1] <= 0) {
            answer += 'C';
        } else {
            answer += 'F';
        }

        if(result[2] <= 0) {
            answer += 'J';
        } else {
            answer += 'M';
        }

        if(result[3] <= 0) {
            answer += 'A';
        } else {
            answer += 'N';
        }

        System.out.println(result[2]);
        return answer;
    }
}

// 상위 정답
class Pro118666Answer {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> point = new HashMap<Character, Integer>();

        // 점수 기록할 배열 초기화
        for (char[] t : type) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }

        // 점수 기록
        for (int idx = 0; idx < choices.length; idx++){
            if(choices[idx] > 4){
                point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
            } else {
                point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
            }
        }

        // 지표 별 점수 비교 후 유형 기입
        for (char[] t : type) {
            answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
        }

        return answer;
    }
}