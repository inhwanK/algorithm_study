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
        for(int i=0; i<tmp.length(); i++) {
            arr[i] = tmp.charAt(i) - '0';
        }

        int answer = 0;

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > 5) {
                answer += 10-arr[i];

                if(i==0) answer++;
                else arr[i-1]++;
            }
            else if(arr[i]==5 && i>0 && arr[i-1]>=5) {
                arr[i-1]++;
                answer += 5;
            }
            else {
                answer += arr[i];
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