package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// OX 퀴즈
// 컨디션 안좋아서 못품 ㅠㅠㅠㅠㅠ
public class Bj8958 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());	//테스트 케이스
		
		String arr[] = new String[test_case];
 
		for (int i = 0; i < test_case; i++) {
			arr[i] = br.readLine();
		}
 
		
		for (int i = 0; i < test_case; i++) {
			
			int cnt = 0;	// 연속횟수
			int sum = 0;	// 누적 합산 
			
			for (int j = 0; j < arr[i].length(); j++) {
				
				if (arr[i].charAt(j) == 'O') {
					cnt++;
				} else {
					cnt = 0;
				}
				sum += cnt;
			}
			
			sb.append(sum).append('\n');
		}
		
		System.out.print(sb);
	}
}
