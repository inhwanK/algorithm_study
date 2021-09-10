package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class Bj3052 {
	public static void main(String[] args) throws IOException {
		
		/* 정렬을 이용한 풀이
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] input = new int[10];
		for (int i = 0; i < 10; i++) {
			input[i] = Integer.parseInt(br.readLine()) % 42;
			
		}
		br.close();

		Arrays.sort(input);

		int num = input[0];
		int count = 1;

		for (int i = 1; i < 10; i++) {
			if (input[i] != num) {
				count++;
			}
			num = input[i];
		}
		System.out.println(count);
		*/
	}
}
