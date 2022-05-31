package algorithm_study.tic.chap12;

import java.util.Scanner;

// 럭키 스트레이트 풀이 (맞춤)
public class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextInt() + "";

        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n.length(); i++) {

            if (i >= n.length() / 2) {
                leftSum += n.charAt(i) - '0';
            } else {
                rightSum += n.charAt(i) - '0';
            }
        }

        if (rightSum == leftSum) {
            System.out.print("LUCKY");
        } else {
            System.out.print("READY");
        }

    }
}
