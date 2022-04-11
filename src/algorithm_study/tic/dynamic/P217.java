package algorithm_study.tic.dynamic;

import java.util.Scanner;

public class P217 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[] store = new int[x + 1];
        store[1] = 0;
        store[2] = 1;


        for (int i = 3; i < x + 1; i++) {
            int temp = 30001;
            System.out.println("반복문 도는중");

            if (i % 5 == 0) {

                if (temp > store[i / 5]) {
                    temp = store[i / 5];
                    System.out.println("5로 나누기");
                }
            }
            if (i % 3 == 0) {

                if (temp > store[3 / i]) {
                    temp = store[i / 3];
                    System.out.println("3으로 나누기");
                }
            }
            if (i % 2 == 0) {
                if (temp > store[i / 2]) {
                    temp = store[i / 2];
                    System.out.println("2로 나누기");
                }
            }

            if (temp > store[i - 1]) {
                System.out.println("1빼기");
                temp = store[i - 1];
            }

            store[i] = temp + 1;
            System.out.println(i + " : " + store[i]);
        }

        System.out.println(store[x]);

    }
}
