package algorithm_study.programers.level3;

import java.util.*;

// 이중우선순위 큐 - https://school.programmers.co.kr/learn/courses/30/lessons/42628
public class Pro42628 {
    public int[] solution(String[] operations) {

        List<Integer> list = new ArrayList();

        for (String command : operations) {
            String[] oper = command.split(" ");

            if (oper[0].equals("I")) {
                int value = Integer.parseInt(oper[1]);
                list.add(value);
                Collections.sort(list);
                continue;
            }

            if (oper[0].equals("D") && oper[1].equals("1") && !list.isEmpty()) {
                list.remove(list.size() - 1);
                continue;
            }

            if (oper[0].equals("D") && oper[1].equals("-1") && !list.isEmpty()) {
                list.remove(0);
            }

        }

        int[] answer = new int[2];

        if (list.isEmpty()) {
            return answer;
        }

        answer[0] = list.get(list.size() - 1);
        answer[1] = list.get(0);

        return answer;
    }
}

class Pro42628Answer {
    public int[] solution(String[] arguments) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < arguments.length; i++) {
            String temp[] = arguments[i].split(" ");
            switch (temp[0]) {
                case "I":
                    pq.add(Integer.parseInt(temp[1]));
                    reverse_pq.add(Integer.parseInt(temp[1]));
                    break;
                case "D":
                    if (pq.size() > 0) {
                        if (Integer.parseInt(temp[1]) == 1) {
                            // 최댓값 삭제
                            int max = reverse_pq.poll();
                            pq.remove(max);
                        } else {
                            // 최솟값 삭제
                            int min = pq.poll();
                            reverse_pq.remove(min);
                        }
                    }
                    break;
            }
        }

        if (pq.size() >= 2) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }

        System.out.println(answer[0] + ":" + answer[1]);

        return answer;
    }
}
