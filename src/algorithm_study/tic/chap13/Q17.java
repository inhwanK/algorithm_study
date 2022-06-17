package algorithm_study.tic.chap13;

import java.util.*;

/*
입력값
3 3
1 0 2
0 0 0
3 0 0
2 3 2

3 3
1 0 2
0 0 0
3 0 0
1 2 2
*/
// 경쟁적 전염
public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        sc.nextLine();
        int[][] arr = new int[n][n];
        ArrayList<Virus> virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] != 0) virusList.add(new Virus(i, j, arr[i][j], 0));
            }
        }

        sc.nextLine();
        int s = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 상하좌우 증식
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Collections.sort(virusList);
        // 증식 순서를 위한 큐
        Queue<Virus> infection = new LinkedList<Virus>();
        for (int i = 0; i < virusList.size(); i++) {
            infection.offer(virusList.get(i));
        }
        // 큐가 빌 때까지 반복
        while (!infection.isEmpty()) {
            Virus virus = infection.poll();
            if(virus.getSecond() == s) break;

            for (int i = 0; i < 4; i++) {
                int nx = virus.getRow() + dx[i];
                int ny = virus.getCol() + dy[i];
                // 시험관을 벗어나는지 확인, 바이러스 존재 여부 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                else if (arr[nx][ny] != 0) continue;
                // 증식
                arr[nx][ny] = virus.getType();
                infection.offer(new Virus(nx, ny, virus.getType(), virus.getSecond() + 1));
            }
        }
        System.out.println(arr[x - 1][y - 1]);
    }
}

class Virus implements Comparable<Virus> {
    private int row;
    private int col;
    private int type;
    private int second;

    public Virus(int row, int col, int type, int second) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.second = second;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getType() {
        return this.type;
    }

    public int getSecond() {
        return this.second;
    }

    public int compareTo(Virus other) {
        return this.getType() - other.getType();
    }
}
