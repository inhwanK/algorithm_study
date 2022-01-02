package algorithm_study.hustar.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P99 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = 0;
		while (N != 1) {
			count++;
			if (N % K != 0) {
				N--;
				bw.write(count + "번째 > 빼기 연산 " + N + " \n");
			} else {
				N /= K;
				bw.write(count + "번째 > 나누기 연산 " + N + " \n");
			}
		}

		bw.write("정답 >" + count);

		br.close();
		bw.close();
	}
}
