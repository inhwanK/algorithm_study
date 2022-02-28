package algorithm_study.tic.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P115 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String loc = br.readLine();
		int col = loc.charAt(0) - 96;
		int row = loc.charAt(1) - '0';

		System.out.println("col > " + col);
		System.out.println("row > " + row);

		int[] ts = { 2, 2, -2, -2, 1, 1, -1, -1 };
		int[] os = { -1, 1, -1, 1, -2, 2, -2, 2 };

		int ci, ri, count = 0;

		for (int i = 0; i < ts.length; i++) {

			ci = 0;
			ri = 0;

			ci = col + ts[i];
			ri = row + os[i];

			System.out.println("ci = " + ci);
			System.out.println("ri = " + ri);

			if (ci < 1 || ci > 8 || ri < 1 || ri > 8) {

				System.out.println("정원을 벗어났습니다. > " + (8 - count));
				continue;
			} else {
				count++;
			}
			System.out.println("경우의 수 = " + count);
		}

		bw.write("최종 경우의 수 = " + count);

		bw.close();
		br.close();
	}
}
