package algorithm_study.programers.level3;

// 네트워크 - https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Pro43162 {
    static int n;
    static boolean[] check;

    public int solution(int n, int[][] computers) {
        // 정적 변수 초기화
        check = new boolean[n];
        this.n = n;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }
            dfs(0, i, computers);
            answer++;
        }

        return answer;
    }

    public void dfs(int depth, int i, int[][] computers) {
        for (int j = 0; j < n; j++) {
            if (check[j]) {
                continue;
            }

            if (i == j) {
                continue;
            }

            if (computers[i][j] == 1) {
                check[j] = true;
                dfs(depth + 1, j, computers);
            }
        }
    }
}

class Pro43162Answer {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] chk = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!chk[i]) {
                dfs(computers, chk, i);
                answer++;
            }
        }
        return answer;
    }
    void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }
}