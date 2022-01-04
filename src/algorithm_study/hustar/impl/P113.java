package algorithm_study.hustar.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

public class P113 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		int N = Integer.parseInt(n);
		
		String min;
		String sec;

		int count = 0;

		if(n.contains("3")) {
			count++;
		}else {
			for (int i = 0; i < 60; i++) {

				min = "" + i;
				
				if (min.contains("3")) {
					count++;
				} else {
					for (int j = 0; j < 60; j++) {
						sec = "" + j;
						if(sec.contains("3")) {
							count++;
						}
					}// for 문 끝
				}

			}// for 문 끝

		}
		
				
		int result = N * count;
		
		
		bw.write("" + result);

		bw.close();
		br.close();
	}
}
