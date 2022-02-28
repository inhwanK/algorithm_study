package algorithm_study.tic.impl;

import java.util.Scanner;

public class P118 {

	public static void main(String[] args) {

//		입력 시작
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine(); // 줄바꿈.

		int A = sc.nextInt();
		int B = sc.nextInt();
		int d = sc.nextInt();
		sc.nextLine(); // 줄바꿈.

		int[][] field = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				field[i][j] = sc.nextInt();
			}
			sc.nextLine();
		}
// 입력 끝

//		초기 위치 값 설정.
		field[A][B] = 1;
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { -1, 0, 1, 0 };

		int left = 0;
		int back = 0;

		int dA = 0;
		int dB = 0;

		int count = 1;
		int nm = 0;

		while (true) {

			// 왼쪽과 뒤쪽 방향 계산.
			left = d - 1 == -1 ? 3 : d - 1;
			back = d - 2 < 0 ? (4 + d) - 2 : d - 2;

			dA = A + dy[left];
			dB = B + dx[left];

			System.out.println(dA + "," + dB);

//			왼쪽 방향 체크후
			if (field[dA][dB] == 0) {

				d = left;
				A = dA;
				B = dB;
				field[A][B] = 2;
				nm = 0;
				count++;
				System.out.println("count :" + count);

			} else {
				nm++;
				d = left;

				if (nm == 4) {

					int bA = A + dy[back];
					int bB = B + dx[back];

					if (field[bA][bB] == 1) {
						break;
					} else {
						A = bA;
						B = bB;
					}
				}

			} // end of else

		}

		System.out.println(count);

		sc.close();
	}
}
