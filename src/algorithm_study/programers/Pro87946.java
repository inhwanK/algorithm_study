package algorithm_study.programers;

// 피로도 - https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Pro87946 {
    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return answer;
    }

    public void dfs(int h, int count, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (h >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                dfs(h - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(count, answer);
    }
}
