package algorithm_study.tic.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 예제문제 포함 대략 100문제 있음.
public class P92 {
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

		st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		int first = arr[N - 1];
		int second = arr[N - 2];

		int das = first * K + second;

		int multi = M / (K + 1);
		int addition = first * (M % (K + 1));

		int sum = das * multi + addition;

		bw.write("정답 > " + sum);

		br.close();
		bw.close();
	}
}
