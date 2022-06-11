package algorithm_study.tic.chap12;

import java.util.*;

/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L

10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
 */
public class Q11 {
    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int k = sc.nextInt();

        // 정사각 보드
        int[][] board = new int[n][n];
        for (int i = 0; i < k; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            board[y][x] = 1;
        }

        int l = sc.nextInt();
        Map<Integer, Character> dirInfo = new HashMap<Integer, Character>();
        for (int i = 0; i < l; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            dirInfo.put(x, c);
        }

        int time = 0;
        int y = 0;
        int x = 0;

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int direction = 0;
        // 뱀 생성
        Queue<Body> snake = new LinkedList<>();
        snake.offer(new Body(y, x));

        while (true) {
            // 방향 전환
            if (dirInfo.getOrDefault(time, null) != null) {
                direction = turn(dirInfo.get(time), direction);
            }
            // 한 칸씩 이동
            y = y + dy[direction];
            x = x + dx[direction];
            // 벽에 닿진 않는지, 자기 몸에 닿진 않는지 검사
            if (!check(y, x, n, snake)) break;

            snake.offer(new Body(y, x));
            // 사과가 있을 경우 꼬리가 늘어남
            if (board[y][x] != 1) {
                snake.poll();
            }
            time++; // 1초씩 증가
        }

        System.out.println(time + 1);
    }

    //
    static boolean check(int y, int x, int n, Queue<Body> snake) {
        if (y >= n || y < 0 || x >= n || x < 0) return false;

        for (Body body : snake) {
            if (body.y == y && body.x == x) return false;
        }
        return true;
    }

    static int turn(char c, int direction) {
        if (c == 'L') {
            direction--;
            if (direction < 0) direction = 3;
        } else {
            direction++;
            if (direction > 3) direction = 0;
        }
        return direction;
    }
}

class Body {
    int y;
    int x;

    Body(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public String toString() {
        return "y = " + y + ", x = " + x;
    }
}