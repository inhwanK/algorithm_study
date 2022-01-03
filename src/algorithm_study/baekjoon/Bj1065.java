package algorithm_study.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		int N = Integer.parseInt(n);

		int result;
		int first;
		int second;
		int third;

		Integer sub = 0;
		int count = 0;

		if (N < 100) {
			result = N;
		} else {
			/*
			for (int i = N + 1; i <= 1000; i++) {

				third = i % 10;
				second = ((i % 100) - third) / 10;
				first = i / 100;

				sub = first - second;
				if (sub.compareTo(second - third) == 0) {
					count++;
				}
			}

			result = 144 - count;
			*/
			
			for (int i = 100; i <= N; i++) {

				third = i % 10;
				second = ((i % 100) - third) / 10;
				first = i / 100;

//				sub = first - second;
				if ((first - second) == (second - third)) {
					count++;
				}
			}

			result = 99 + count;

		}

		bw.write("" + result);
//		bw.write("정답 > " + result);

		br.close();
		bw.close();
	}

}
