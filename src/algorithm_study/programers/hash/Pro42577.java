package algorithm_study.programers.hash;

import java.util.*;

// 정렬로 푸는 방법
// 전화번호 목록 - https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class Pro42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String pre = phone_book[i];
            if (phone_book[i + 1].startsWith(pre)) {
                return false;
            }
        }

        return answer;
    }
}

// 해시맵을 사용하는 방법
class Pro42577Answer {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        for(int i = 0; i < phone_book.length; i++) {
            String input = phone_book[i];
            for(int j = 1; j < input.length(); j++) {
                if(map.containsKey(input.substring(0, j))) return false;
            }
        }

        return answer;
    }
}