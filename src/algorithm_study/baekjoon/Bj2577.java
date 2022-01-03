package algorithm_study.baekjoon;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bj2577 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int value = A * B * C;
		String answer = Integer.toString(value);
		int key = 0;
		
		Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();

		for (int i = 0; i < 10; i++) {
			numCount.put(i, 0);
		}
		
		for (int num = 0; num < answer.length(); num++) {
			key = answer.charAt(num)- '0';
			numCount.replace(key, numCount.get(key) +1);
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(numCount.get(i));
		}
	}
}
