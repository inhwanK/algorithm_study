package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// �룊洹좎� �꽆寃좎�

public class Bj4344 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		String[] nList = new String[N];

		for (int n = 0; n < N; n++) {
			nList[n] = br.readLine();
		}

		StringTokenizer st;
		float sum = 0;
		float avg = 0;
		for (int i = 0; i < nList.length; i++) {
			st = new StringTokenizer(nList[i], " ");
			float nSub = Integer.parseInt(st.nextToken());
			float[] std = new float[(int) nSub];

			float score = 0;
			for (int j = 0; j < nSub; j++) {
				score = Integer.parseInt(st.nextToken());
				std[j] = score;
				sum += score;
			}

			avg = sum / nSub;
			int count = 0;
			for (int a = 0; a < nSub; a++) {
				if (std[a] <= avg) {
					count++;
				}
			}
			float ans = (count / nSub) * 100f;
			System.out.println(String.format("%.3f", ans)+"%");
		}
	}
}
