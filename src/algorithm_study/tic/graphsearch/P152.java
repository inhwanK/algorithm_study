package algorithm_study.tic.graphsearch;

import java.util.Scanner;

public class P152 {

	private static int N, M;
	private static int[][] maze;
	private static int result = 0;

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

		int shortRoad = 0;
		int result = getDirections(shortRoad, 0, 0);

		System.out.println("답은? > " + result);
	}

//	길찾기 메서드
	public static int getDirections(int shortRoad, int n, int m) {

		int re = 1000001;

		if (n == N - 1 && m == M - 1) {
			if (shortRoad < re) {
				re = shortRoad + 1;
			}
			return re;
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
			int right = getDirections(shortRoad, n, m + 1);
			int down = getDirections(shortRoad, n + 1, m);

			if (shortRoad == roadCheck) {
				int left = getDirections(shortRoad, n, m - 1);
				int up = getDirections(shortRoad, n - 1, m);
			}

			System.out.println("if 문 결과 > " + shortRoad);

		} else {
			System.out.println("else 결과 > " + shortRoad);
		}
		
	}
}
