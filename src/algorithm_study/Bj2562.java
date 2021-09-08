package algorithm_study;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Bj2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int max = 0;
		int val = 0;
		int count = 0;
		int index = 0;
		String input = null;

		while (true) {
			input = br.readLine();
			val = Integer.parseInt(input);

			if (max < val) {
				max = val;
				index = count;
			}

			count++;
			if (count >= 9) {
				break;
			}
		}

		bw.write(Integer.toString(max) + "\n");
		bw.write(Integer.toString(index + 1));

		bw.flush();
		br.close();
		bw.close();

	}
}