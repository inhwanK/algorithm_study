package algorithm_study.programers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 무인도 여행 - https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class Pro154540 {
    class Island {
        int x;
        int y;
        int number;

        public Island(int x, int y, char number) {
            this.x = x;
            this.y = y;
            this.number = number - '0';
        }
    }


    public int[] solution(String[] maps) {
        int[] answer = {-1};
        int colSize = maps[0].length();
        char[][] island = new char[maps.length][colSize];

        boolean[][] visited = new boolean[maps.length][colSize];
        ArrayList<Integer> list = new ArrayList();


        for (int i = 0; i < maps.length; i++) {
            island[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < colSize; j++) {
                if (visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                if (island[i][j] == 'X') {
                    continue;
                }

                int sum = bfs(new Island(i, j, island[i][j]), visited, island);
                list.add(sum);
            }
        }

        if (list.isEmpty()) {
            return answer;
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    private int bfs(Island target, boolean[][] visited, char[][] island) {
        Queue<Island> que = new LinkedList();
        int sum = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        que.add(target);

        while (!que.isEmpty()) {
            target = que.poll();

            sum += target.number;
            int x = target.x;
            int y = target.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= island.length || ny < 0 || ny >= island[0].length) {
                    continue;
                }

                if (!visited[nx][ny] && island[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    que.add(new Island(nx, ny, island[nx][ny]));
                }
            }
        }

        return sum;
    }
}
