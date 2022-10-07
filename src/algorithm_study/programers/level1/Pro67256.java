package algorithm_study.programers.level1;

import java.util.*;

// 키패드 누르기 - https://school.programmers.co.kr/learn/courses/30/lessons/67256
public class Pro67256 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        Map<String, Pad> keyPad = new HashMap();
        int num = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                keyPad.put(num + "", new Pad(i, j));
                num++;
            }
        }

        keyPad.put("*", new Pad(3, 0));
        keyPad.put(0 + "", new Pad(3, 1));
        keyPad.put("#", new Pad(3, 2));

        Pad left = keyPad.get("*");
        Pad right = keyPad.get("#");

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append('L');
                left = keyPad.get(numbers[i] + "");
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append('R');
                right = keyPad.get(numbers[i] + "");
            } else {
                Pad now = keyPad.get(numbers[i] + "");
                if (now.getDistance(left) < now.getDistance(right)) {
                    sb.append('L');
                    left = keyPad.get(numbers[i] + "");
                } else if (now.getDistance(left) > now.getDistance(right)) {
                    sb.append('R');
                    right = keyPad.get(numbers[i] + "");
                } else {
                    if (hand.equals("right")) {
                        sb.append('R');
                        right = keyPad.get(numbers[i] + "");
                    } else {
                        sb.append('L');
                        left = keyPad.get(numbers[i] + "");
                    }
                }
            }
        }


        return sb.toString();
    }

    public String solution_answer(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int tmp : numbers) {
            if (tmp == 1 || tmp == 4 || tmp == 7) {
                answer += "L";
                left = tmp;
            } else if (tmp == 3 || tmp == 6 || tmp == 9) {
                answer += "R";
                right = tmp;
            } else {
                if (tmp == 0) tmp = 11;
                int leftdist = Math.abs(tmp - left) / 3 + Math.abs(tmp - left) % 3;
                int rightdist = Math.abs(tmp - right) / 3 + Math.abs(tmp - right) % 3;

                if (leftdist < rightdist) {
                    answer += "L";
                    left = tmp;
                } else if (leftdist > rightdist) {
                    answer += "R";
                    right = tmp;
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        left = tmp;
                    } else {
                        answer += "R";
                        right = tmp;
                    }
                }
            }
        }
        return answer;
    }
}

class Pad {
    public int x;
    public int y;

    public Pad(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDistance(Pad pad) {
        return Math.abs(this.x - pad.x) + Math.abs(this.y - pad.y);
    }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/67256/solution_groups?language=java
class Pro67256Answer {
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";
        for (int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }

    //num버튼을 누를 때 어디 손을 사용하는가
    private String pushNumber(int num) {
        if(num==1 || num==4 || num==7) return "L";
        if(num==3 || num==6 || num==9) return "R";

        // 2,5,8,0 일때 어디 손가락이 가까운가
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        //같으면 손잡이
        return this.hand;
    }

    //해당 위치와 번호 위치의 거리
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
}