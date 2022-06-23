package algorithm_study.tic.chap15;

import java.util.*;

// 공유기 설치
public class Q29 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int start = 1;
        int end = list.get(n - 1) - list.get(0);
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int value = list.get(0);
            int count = 1;

            for (int i = 1; i < n; i++) {
                if (list.get(i) >= value + mid) {
                    value = list.get(i);
                    count++;
                }
            }

            if (count < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
