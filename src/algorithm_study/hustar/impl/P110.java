package algorithm_study.hustar.impl;

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

//		Map<String, Integer> mv = new HashMap<String, Integer>();
//		mv.put("L", -1);
//		mv.put("R", 1);
//		mv.put("U", -1);
//		mv.put("D", 1);

		String move;

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			move = st.nextToken();

			
//			if (move == "L") {
//				col--;
//			} else if (move == "R") {
//				col++;
//			} else if (move == "U") {
//				row--;
//			} else if(move == "D"){
//				row++;
//			}
//
//			if (col < 1) {
//				col = 1;
//			} else if (col > N) {
//				col = N;
//			} else if (row < 1) {
//				row = 1;
//			} else if (row > N) {
//				row = N;
//			}
		}

		bw.write(row + " "+ col);
		br.close();
		bw.close();
	}
}
