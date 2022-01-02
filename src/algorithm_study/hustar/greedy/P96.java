package algorithm_study.hustar.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P96 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = 0;
		int[][] card = new int[N][M];

		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				card[j][i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(card[j]);

			if (max <= card[j][0]) {
				max = card[j][0];
			}

		}

		bw.write("정답 > " + max);
		
		bw.close();
		br.close();
	}
}
