package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균은 넘겠지

public class Bj4344 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		String[] nList = new String[N];

		for (int n = 0; n < N; n++) {
			nList[n] = br.readLine();
		}

		StringTokenizer st;

		for (int i = 0; i < nList.length; i++) {
			st = new StringTokenizer(nList[i], " ");
			String nSub = st.nextToken();

			for (int j = 0; j < st.countTokens(); j++) {

			}
		}
	}
}
