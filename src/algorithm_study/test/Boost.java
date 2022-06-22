package algorithm_study.test;

import java.util.ArrayList;

public class Boost {
    public static void main(String[] args) {
        int[] count = new int[101];
//        int[] arr = {1, 2, 3, 3, 3, 3, 4, 4};
        int[] arr = {3, 2, 4, 4, 2, 5, 2, 5, 5};

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 101; i++) {
            if (count[i] > 1) {
                list.add(count[i]);
            }
        }

//        Integer[] out = (Integer[]) list.toArray();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.toArray()[i] + " ");
        }

        System.out.print(list.toArray());
    }
}

//Map
//Set 이용해서 각각 풀어보기
