package algorithm_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Bj2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		br.close();

		int value = A * B * C;
		System.out.println(value);
		String answer = value + "";
		int num = 0;
		int[] count = new int[9];

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 불필요한 반복이 있음.
		// 다른 자료구조를 활용해야함.
		
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		System.out.println(countMap);
		
//		countMap.get(countMap)
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < answer.length(); j++) {
				num = answer.charAt(j) - '0';
				if(countMap.containsKey(num)) {
					int tmp = countMap.get(num)+1;
					countMap.replace(num, tmp);
				}else {
					countMap.put(num, 1);
				}
					
				if (i == num) {
					count[i - 1]++;
				}
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
