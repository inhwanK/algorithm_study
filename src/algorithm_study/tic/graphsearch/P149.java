package algorithm_study.tic.graphsearch;

import java.util.Scanner;
import java.util.Stack;

public class P149 {

	static int[][] ice;
	static int N, M;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1 <= N, M <= 1000
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine(); // 버퍼 제거를 위함.

		ice = new int[N][M];
		String numberOfCell;
		// 배열에 값 넣기
		for (int n = 0; n < N; n++) {

			numberOfCell = sc.nextLine();

			for (int m = 0; m < M; m++) {
				ice[n][m] = numberOfCell.charAt(m) - '0';
			}
		}

		// 배열 확인
		System.out.println("배열 함 볼까 > " + ice[0][1]);

		int result = 0;
		// 배열 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (isIceGroup(i, j)) {
					result++;
				}
			}
		}

//		결과
		System.out.println("group > " + result);
	}

	// 얼음 덩어리 확인 메서드
	public static boolean isIceGroup(int row, int col) {

		if (row >= N || row < 0 || col >= M || col < 0) {
			return false;
		}

		if (ice[row][col] == 0) {
			ice[row][col] = 1;

			isIceGroup(row, col + 1);
			isIceGroup(row + 1, col);
			isIceGroup(row, col - 1);
			isIceGroup(row - 1, col);

			return true;
		}
		return false;

	}
}