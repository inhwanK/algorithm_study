package algorithm_study.hustar.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class P113 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		int N = Integer.parseInt(n);

		String hour;
		String min;
		String sec;

		int count = 0;

		for (int h = 0; h <= N; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {

					hour = h + "";
					min = m + "";
					sec = s + "";
					if (hour.contains("3") || min.contains("3") || sec.contains("3")) {
						count++;
					}

				}
			}
		}

		bw.write("" + count);

		bw.close();
		br.close();
	}
}
