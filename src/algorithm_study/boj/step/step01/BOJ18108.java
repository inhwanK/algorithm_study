package algorithm_study.boj.step.step01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1998년생인 내가 태국에서는 2541년생?! - https://www.acmicpc.net/problem/18108
public class BOJ18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 543
        System.out.println(Integer.parseInt(br.readLine()) - 543);
    }
}