package algorithm_study.tic.chap12;

import java.util.ArrayList;
import java.util.Scanner;

// 치킨 배달
public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] city = new int[n][n];
        ArrayList<Chicken> chickenList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                if (value == 2) {
                    chickenList.add(new Chicken(i, j));
                }
                city[i][j] = value;
            }
        }

        // 모든 치킨 집 중 m 만큼 뽑기. 조합.
        // 조합 길이, 전체 길이,
        Chicken[] combiArr = new Chicken[chickenList.size()];
        boolean[] visited = new boolean[chickenList.size()];
        combination(chickenList, combiArr, visited, m, 0);


        // 조합별 치킨 거리 계산

        // 가장 작은 치킨 거리 저장

    }

    public static Chicken[] combination(ArrayList<Chicken> list, Chicken[] combiArr, boolean[] visited, int m, int start) {
        if (m == 0) {
            System.out.println(combiArr[0]);
            return combiArr;
        }

        int index = combiArr.length - m;
        for (int i = start; i <= list.size() - m; i++) {
            visited[i] = true;
            combiArr[index] = list.get(i);
            combination(list, combiArr, visited, m - 1, start + 1);
            visited[i] = false;
            return combiArr;
        }
        return null;
    }
}

class Chicken {
    int col;
    int row;

    public Chicken(int col, int row) {
        this.col = col;
        this.row = row;
    }
}