package algorithm_study.tic.chap12;

import java.util.ArrayList;
import java.util.Scanner;

// 치킨 배달
public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Posi> chickenList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                if (value == 2) chickenList.add(new Posi(i, j));
            }
        }

        // 모든 치킨 집 중 m 만큼 뽑기. 조합.

        // 조합 별 치킨 거리 계산

        // 가장 작은 치킨 거리 저장

    }


}