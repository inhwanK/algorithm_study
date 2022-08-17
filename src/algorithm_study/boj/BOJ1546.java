package algorithm_study.boj;

import java.util.*;
import java.io.*;

public class BOJ1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int subject = Integer.valueOf(br.readLine());
		float[] score = new float[subject];
		float max = 0;
		float sum = 0;
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < subject; i++) {
			score[i] = Integer.valueOf(st.nextToken());
			
			if(max < score[i]) {
				max = score[i];
			}	
		}

		br.close();
		
		for (int i = 0; i < subject; i++) {
			score[i] = (score[i] / max) * 100;
			sum = sum + score[i];
		}
		
		bw.write((sum / subject) + "");
		bw.flush();
		bw.close();

	}
}
