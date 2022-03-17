package algorithm_study.mogakco.twopointers;

import java.util.Arrays;

public class DopingEx {
    public static void main(String[] args) {

        int[] caffeine = {100, 232, 600, 100, 730, 185, 104, 392, 33, 89};
        int[] taurine = {320, 720, 103, 124, 1076, 125, 600, 705, 265, 421};

        int[] drink = new int[10];

        for (int i = 0; i < 10; i++) {
            drink[i] = taurine[i] - caffeine[i];
        }


        int[] result = new int[3];

        int sum = 0;
        int index = -1;

        for (int i = 0; i < 7; i++) {

            if (sum < drink[i] + drink[i + 1] + drink[i + 2]) {
                sum = drink[i] + drink[i + 1] + drink[i + 2];
                index = i;
            }

        }

        int cafSum = caffeine[index] + caffeine[index + 1] + caffeine[index + 2];
        int tauSum = taurine[index] + taurine[index + 1] + taurine[index + 2];

        System.out.println(index + " " + (index + 1) + " " + (index + 2) + "의 타우린 합은" + tauSum + "카페인 합은 " + cafSum + "로 가장 효과가 좋습니다.");
    }
}
