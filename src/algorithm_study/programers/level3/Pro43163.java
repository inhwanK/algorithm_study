package algorithm_study.programers.level3;

import java.util.LinkedList;
import java.util.Queue;

// 단어 변환 - https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class Pro43163 {
    int result = Integer.MAX_VALUE;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new boolean[words.length];
        dfs(0, begin, target, words);

        answer = result;
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }

    public void dfs(int change, String now, String target, String[] words) {
        if (now.equals(target)) {
            result = Math.min(result, change);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && countChangeChar(now, words[i]) == 1) {
                visited[i] = true;
                dfs(change + 1, words[i], target, words);
                visited[i] = false;
            }
        }
    }

    public int countChangeChar(String now, String next) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}


class Pro43163Answer {

    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        // for (int i=0; i<n; i++)
        //  if (words[i] != target && i == n-1) return 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }

        return true;
    }
}