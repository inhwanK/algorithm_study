package algorithm_study.tic.chap05;

import java.util.Scanner;

public class P152 {

	private static int N, M;
	private static int[][] maze;
	private static int result;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();

		String row;
		maze = new int[N][M];

		for (int n = 0; n < N; n++) {

			row = sc.nextLine();
			for (int m = 0; m < M; m++) {
				maze[n][m] = row.charAt(m) - '0';
			}
		} // end of for{}

		sc.close();

		result = 1000001;
		getDirections(0, 0, 0);

		System.out.println("답은? > " + result);
	}
	
//	길찾기 메서드
	public static int getDirections(int shortRoad, int n, int m) {

		if (n == N - 1 && m == M - 1) {
			if (shortRoad < result) {
				result = shortRoad + 1;
			}

			System.out.println("shortRoad 변화 체크 > " + shortRoad);
			System.out.println("result 변화 체크 > " + result);

			return result;
		}

		if (n >= N || n < 0 || m >= M || m < 0) {
			return 1000001;
		}

		if (maze[n][m] == 1) {

			shortRoad++;
			maze[n][m] = 0;

			System.out.println("여기 거치냐?");
			int roadCheck = shortRoad;

			// 빠른길 먼저
			getDirections(shortRoad, n, m + 1);
			getDirections(shortRoad, n + 1, m);

			if (shortRoad == roadCheck) {
				getDirections(shortRoad, n, m - 1);
				getDirections(shortRoad, n - 1, m);
			}

		}

		return shortRoad;
	}
}
