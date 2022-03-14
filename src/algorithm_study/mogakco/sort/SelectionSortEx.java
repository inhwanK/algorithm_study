package algorithm_study.mogakco.sort;

import java.util.Arrays;

public class SelectionSortEx {

    public static void main(String[] args) {

        int[] arr = {9, 6, 7, 3, 5};

        for (int i = 0; i < arr.length; i++) {

            int min = 9999999;
            int minIdx = arr.length;

            for (int j = i; j < arr.length; j++) {

                if (arr[j] < min) {

                    min = arr[j];
                    minIdx = j;
                }
            }

            if(minIdx != i){
                arr[minIdx] = arr[i];
                arr[i] = min;
                System.out.println(Arrays.toString(arr));
            }

        } // for 문 끝

    }
}