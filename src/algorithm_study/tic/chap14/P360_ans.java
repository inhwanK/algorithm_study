package algorithm_study.tic.chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P360_ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }

        Collections.sort(arrayList);

        // 중간값(median)을 출력
        System.out.println(arrayList.get((n - 1) / 2));
    }
}
