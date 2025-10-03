package algorithm_study.programers.level1;

import java.util.*;

// 가장 많이 받은 선물 - https://school.programmers.co.kr/learn/courses/30/lessons/258712
public class Pro258712 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // 로직을 두개로 나눠?

        // 두 사람 사이에 선물 주고받은 기록이 있다면, 선물주기
        // 기록을 찾고
        // 각자 준 횟수를 찾기
        // 2차원 배열?
        // Map<String, List<String>>, int[][]
        // 두 사람 사이에 주고 받은 기록이 없다면, 또는 수가 같다면
        //

        // 풀기
        int[][] points = new int[friends.length][friends.length];
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        // points 값 넣기, 선물 주는 쪽은 row, 받는 쪽은 col
        for (int i = 0; i < gifts.length; i++) {
            String[] giftFriends = gifts[i].split(" ");
            int giver = map.get(giftFriends[0]);
            int receiver = map.get(giftFriends[1]);
            points[giver][receiver]++;
        }

        int[] result = new int[points.length];
        int[] giftPoint = new int[points.length];
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points[0].length; j++) {
                // 선물 지수 구하기
                giftPoint[i] += points[i][j];
                giftPoint[i] -= points[j][i];
            }
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points[0].length; j++) {
                // 주고받은 기록 있고, 비교될 때
                if(points[i][j] > points[j][i]) {
                    result[i]++;
                } else if(points[i][j] < points[j][i]) {
                    result[j]++;
                } else {
                    if(giftPoint[i] > giftPoint[j]) {
                        result[i]++;
                    } else if(giftPoint[i] < giftPoint[j]){
                        result[j]++;
                    }
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }

        return answer;
    }
}
