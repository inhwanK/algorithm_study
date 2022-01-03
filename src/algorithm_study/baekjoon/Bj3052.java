package algorithm_study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;



public class Bj3052 {
	public static void main(String[] args) throws IOException {
		
		// Set�� �̿��� Ǯ��.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int value = 0;
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 10; i++) {
			value = Integer.valueOf(br.readLine());
			set.add(value%42);
		}
		System.out.println(set.size());
		
		
		/* ������ �̿��� Ǯ��
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
