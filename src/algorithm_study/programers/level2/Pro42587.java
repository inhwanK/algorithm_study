package algorithm_study.programers.level2;

import java.util.*;

// 프린터 - https://school.programmers.co.kr/learn/courses/30/lessons/42587
public class Pro42587 {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        int[] count = new int[10];
        Queue<Document> que = new LinkedList();

        for (int i = 0; i < priorities.length; i++) {
            que.add(new Document(i, priorities[i]));
            count[priorities[i]]++;
        }

        int prior = 9;
        while (!que.isEmpty()) {
            if (count[prior] == 0) {
                prior--;
                continue;
            }

            Document target = que.peek();
            if (target.priority != prior) {
                que.add(que.poll());
                continue;
            }

            if (target.index != location) {
                que.poll();
                answer++;
                count[prior]--;
            } else {
                break;
            }
        }
        return answer;
    }

    class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}

class Pro42587Answer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for (int i : priorities) {
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length - 1;

        while (!que.isEmpty()) {
            Integer i = que.poll();
            if (i == priorities[size - answer]) {
                answer++;
                l--;
                if (l < 0)
                    break;
            } else {
                que.add(i);
                l--;
                if (l < 0)
                    l = que.size() - 1;
            }
        }
        return answer;
    }
}