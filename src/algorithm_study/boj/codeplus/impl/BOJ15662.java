package algorithm_study.boj.codeplus.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 톱니바퀴 (2) - https://www.acmicpc.net/problem/15662
public class BOJ15662 {
    static int n;
    static int[][] gearInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        gearInfo = new int[n][8];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gearInfo[i][j] = line.charAt(j) - '0';
            }
        }

        int rotateCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < rotateCount; i++) {
            String[] line = br.readLine().split(" ");
            int gearNum = Integer.parseInt(line[0]) - 1;
            int dirClock = Integer.parseInt(line[1]);

            // 해당 시계 돌리는 메서드 수행
            compute(gearNum, dirClock, 0);
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(gearInfo[i][0] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    // 필요한 파라미터 톱니바퀴 배열, 본인 톱니바퀴, 회전 방향
    private static void compute(int gearNum, int dirClock, int dir) {
        // 돌리기 전에 극 값 저장
        int leftPole = gearInfo[gearNum][6];
        int rightPole = gearInfo[gearNum][2];

        // 시계 돌리기
        if (dirClock == 1) {
            rotateClock(gearNum);
        } else {
            rotateCounterClock(gearNum);
        }


        // 좌 톱니바퀴 존재 여부 확인
        if (gearNum - 1 >= 0 && (dir == 0 || dir == -1)) {
            // 극이 다르면 compute 메서드 수행
            if (leftPole != gearInfo[gearNum - 1][2]) {
                compute(gearNum - 1, dirClock * -1, -1);
            }
        }

        // 우 톱니바퀴 존재 여부 확인
        if (gearNum + 1 < n && (dir == 0 || dir == 1)) {
            // 극이 다르면 compute 메서드 수행
            if (rightPole != gearInfo[gearNum + 1][6]) {
                compute(gearNum + 1, dirClock * -1, 1);
            }
        }

    }

    private static void rotateClock(int gearNum) {
        int[] copy = Arrays.copyOf(gearInfo[gearNum], 8);
        for (int i = 1; i < 8; i++) {
            gearInfo[gearNum][i] = copy[i - 1];
        }
        gearInfo[gearNum][0] = copy[7];
    }

    private static void rotateCounterClock(int gearNum) {
        int[] copy = Arrays.copyOf(gearInfo[gearNum], 8);
        for (int i = 1; i < 8; i++) {
            gearInfo[gearNum][i - 1] = copy[i];
        }
        gearInfo[gearNum][7] = copy[0];
    }
}