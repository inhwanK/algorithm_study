package algorithm_study.programers.level2;

import java.util.*;

import java.util.LinkedList;

// 마법의 엘리베이터 - https://school.programmers.co.kr/learn/courses/30/lessons/148653
public class Pro148653 {


    public int solution(int storey) {
        int answer = bfs(storey);
        return answer;
    }

    public int bfs(int storey) {
        Queue<Ev> q = new LinkedList<>();
        q.add(new Ev(storey, 0));
        int result = 10000000;
        while (!q.isEmpty()) {
            Ev ev = q.poll();
            int now = ev.now;
            int level = ev.depth;
            if (now == 0) {
                if (result > level) {
                    result = level;
                }
                continue;
            }
            int num = now % 10;
            if (num > 5) { //5보다 크면 걍 반올림
                q.add(new Ev(now / 10 + 1, level + 10 - num));
            } else if (num == 5) {
                q.add(new Ev(now / 10, level + num)); //내림
                q.add(new Ev(now / 10 + 1, level + 10 - num)); //반올림
            } else {
                q.add(new Ev(now / 10, level + num));
            }
        }
        return result;
    }

    public int solutionAnswer1(int storey) {
        String tmp = Integer.toString(storey);
        int[] arr = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++) {
            arr[i] = tmp.charAt(i) - '0';
        }

        int answer = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 5) {
                answer += 10 - arr[i];

                if (i == 0) answer++;
                else arr[i - 1]++;
            } else if (arr[i] == 5 && i > 0 && arr[i - 1] >= 5) {
                arr[i - 1]++;
                answer += 5;
            } else {
                answer += arr[i];
            }

        }

        return answer;
    }

    public int solutionAnswer2(int storey) {

        //마법의 엘리베이터

        //절댓값이 10 ^ c ( c >= 0 인 정수)
        //더한 값으로 이동
        //0보다 작으면 엘리베이터는 움직이지 않습니다.
        //0층이 가장 아래층 -> 엘리베이터 와 민수 모두 0층

        //절반보다 크면 더해서 큰 값을 만드는게 이득
        //절반보다 작으면 빼서 작은 값을 만드는게 이득

        int answer = 0;

        char[] chars = String.valueOf(storey).toCharArray();
        int[] ints = new int[chars.length];

        // 숫자를 문자열로 바꿨다가 다시 int 배열로 변경
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }

        for (int i = ints.length - 1; i >= 0; i--) {
            int anInt = ints[i];

            // 6 이상이므로 앞자리수 증가.
            if (anInt >= 6) {

                answer += (10 - anInt);
                if (i == 0) {
                    answer += 1;
                    continue;
                }

                ints[i - 1]++;

                // 6 이하일 경우 앞자리수가 그대로.
            } else if (anInt <= 4) {
                answer += anInt;
            } else { // 5인 경우

                // 마지막 자리수인 경우 그냥 answer 증가시키고 끝
                if (i == 0) {
                    answer += 5;
                    continue;
                }

                // 마지막 자릿 수 아닌 경우 5보다 작으면 현재 자릿수만큼만 계산
                if (ints[i - 1] < 5) {
                    answer += anInt;
                } else {
                    // 5보다 크면 앞자리수 증가
                    answer += 5;
                    ints[i - 1]++;
                }
            }
        }

        return answer;
    }
}

class Ev {
    int now;
    int depth;

    Ev(int now, int depth) {
        this.now = now;
        this.depth = depth;
    }
}