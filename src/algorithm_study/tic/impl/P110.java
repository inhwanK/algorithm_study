package algorithm_study.tic.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P110 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		int col = 1;
		int row = 1;

		String move;

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			move = st.nextToken();

			switch (move) {

			case "L":
				col--;
				if(col < 1) {
					col = 1;
				}
				break;
			case "R":
				col++;
				if(col > N) {
					col = N;
				}
				break;
			case "U":
				row--;
				if(row < 1) {
					row = 1;
				}
				break;
			case "D":
				row++;
				if(row > N) {
					row = N;
				}
				break;
			}
		}

		bw.write(row + " " + col);
		br.close();
		bw.close();
	}
}
