package algorithm_study.boj.step.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // a = 97
        // z = 122
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int alpha = 'a'; alpha <= 'z'; alpha++) {
            for (int j = 0; j < s.length(); j++) {
                if (alpha == s.charAt(j)) {
                    arr[alpha - 'a'] = j;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

// 1위 답
class BOJ10809Answer {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        int num[] = new int[26];
        for (int i = 0; i < 26; i++) {
            num[i] = -1;
        }

        for (int i = 0; i < arr.length; i++) {
            int loc = arr[i] - 97;


            if (num[loc] == -1) {
                num[loc] = i;
                //System.out.println(arr[i] + " = "+loc);

            }
        }
        for (int i = 0; i <  26; i++) {
            System.out.print(num[i] + " ");
        }
    }

}