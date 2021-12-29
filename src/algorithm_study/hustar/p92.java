package algorithm_study.hustar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p92 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		String n = st.nextToken();
		String m = st.nextToken();
		String k = st.nextToken();

		int N = Integer.parseInt(n);
		int M = Integer.parseInt(m);
		int K = Integer.parseInt(k);

		System.out.println("> " + N);
		System.out.println("> " + M);
		System.out.println("> " + K);

		st = new StringTokenizer(br.readLine(), " ");

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int j = 0; j < N; j++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		arr.sort(Collections.reverseOrder());

		System.out.println("> " + arr.get(0));
		System.out.println("> " + arr.get(1));
		System.out.println("> " + arr.get(2));

		int sum = 0;
		int count = 0;

		for (int i = 0; i < M; i++) {

			if (count != K) {
				sum += arr.get(0);
				count++;
			} else {
				sum += arr.get(1);
				count = 0;
			}
		}

		bw.write("정답 > " + sum);

		br.close();
		bw.close();
	}
}
