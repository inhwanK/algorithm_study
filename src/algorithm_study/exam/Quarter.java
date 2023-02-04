package algorithm_study.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 분기 숫자 구하기
public class Quarter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        System.out.println(getQuarter(month));
    }

    private static int getQuarter(int month) {
        return (month - 1) / 3 + 1;
    }
}
