package algorithm_study.tic.chap13;

import java.util.*;

// 특정 거리의 도시 찾기 풀이 (오답)
public class P339 {

    public static int n, m, k, x;
    public static Queue<Integer> cityQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 도시의 개수
        m = sc.nextInt(); // 도로의 개수
        k = sc.nextInt(); // 거리 정보
        x = sc.nextInt(); // 출발 도시의 번호

        int[][] city = new int[n + 1][n + 1];
//        int[] visit = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            city[a][b] = 1;
        }

        bfs(city, x, 0);
    }

    static void bfs(int[][] adjArr, int x, int count) {

        cityQueue.offer(x);
        for (int i = 1; i <= n; i++) {
            if (adjArr[x][i] == 1) {

                cityQueue.offer(i);
//                if (count == k) result++;
            }
        }

        if (cityQueue.poll() != null) {
            count++;
            bfs(adjArr, cityQueue.peek(), count);
        } else {
            return;
        }


    }
}
