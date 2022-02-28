package algorithm_study.tic.graphsearch;

import java.util.Scanner;
import java.util.Stack;

public class P149 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1 <= N, M <= 1000
		int N, M;

		N = sc.nextInt();
		M = sc.nextInt();

		int[][] ice = new int[N][M];

		// 배열에 값 넣기
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				ice[n][m] = sc.nextInt();
			}
		}

		// 배열 확인
		System.out.println("배열 함 볼까 > " + ice[0][1]);

		// 스택이냐 큐냐
		Stack<Integer> connIce = new Stack<Integer>();

		// 시작 요소 ice[0][0]
		// 열 값을 우선으로 탐색
		
		// 배열 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if(ice[i][j] == 1) {
//					ice[i][j] = 
				}
				
			}
		}
		
	}
}