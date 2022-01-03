package algorithm_study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// OX ����
// ����� �����Ƽ� ��ǰ �ФФФФ�
public class Bj8958 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());	//�׽�Ʈ ���̽�
		
		String arr[] = new String[test_case];
 
		for (int i = 0; i < test_case; i++) {
			arr[i] = br.readLine();
		}
		
		for (int i = 0; i < test_case; i++) {
			
			int cnt = 0;	// ����Ƚ��
			int sum = 0;	// ���� �ջ� 
			
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
		
		/*
		 * 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringBuilder sb = new StringBuilder();
 
		int test_case = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽�
 
		for (int i = 0; i < test_case; i++) {
 
			int cnt = 0; // ����Ƚ��
			int sum = 0; // ���� �ջ�
 
			for (byte value : br.readLine().getBytes()) {
				
				if (value == 'O') {
					cnt++;
					sum += cnt;
				} 
				else {
					cnt = 0;
				}
			}
			
			sb.append(sum).append('\n');
 
		}
		System.out.println(sb);
		 */
	}
}
