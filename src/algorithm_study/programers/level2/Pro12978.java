package algorithm_study.programers.level2;

// 배달 - https://school.programmers.co.kr/learn/courses/30/lessons/12978
public class Pro12978 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] cities = new int[N + 1][N + 1];

        for (int i = 1; i < cities.length; i++) {
            for (int j = 1; j < cities.length; j++) {
                if (i == j) {
                    continue;
                }
                cities[i][j] = 500_001;
            }
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int dis = road[i][2];

            cities[a][b] = Math.min(cities[a][b], dis);
            cities[b][a] = Math.min(cities[b][a], dis);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (cities[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
