package algorithm_study.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 사용하지 않는 가장 작은 숫자 찾기
public class MinNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] arr = new int[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(searchMinNumber(arr));
    }

    private static int searchMinNumber(int[] arr) {
        boolean[] cArr = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cArr[i] = true;
        }

        for (int i = 0; i < cArr.length; i++) {
            if (!cArr[i]) {
                return i;
            }
        }
        return cArr.length;
    }
}
