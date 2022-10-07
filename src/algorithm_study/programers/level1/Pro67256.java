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