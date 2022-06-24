package algorithm_study.boj;

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

		int count = 0;

		if (N < 100) {
			result = N;
		} else {

			for (int i = 100; i <= N; i++) {

				third = i % 10;
				second = ((i % 100) - third) / 10;
				first = i / 100;


				if ((first - second) == (second - third)) {
					count++;
				}
			}

			result = 99 + count;

		}
		bw.write("" + result);

		br.close();
		bw.close();
	}

}
