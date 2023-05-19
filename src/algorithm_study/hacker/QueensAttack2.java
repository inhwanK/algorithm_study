package algorithm_study.hacker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QueensAttack2 {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {

        int[][] board = new int[n + 1][n + 1];

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        int answer = 0;
        // 8 direction check
        for (int dir = 0; dir < 8; dir++) {
            int nx = r_q + dx[dir];
            int ny = c_q + dy[dir];

            while (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                board[nx][ny] = 1;
                answer++;
                // System.out.println(nx + " - " + ny + " : " + board[nx][ny]);
                nx = nx + dx[dir];
                ny = ny + dy[dir];
            }
        }

        // detect obstacle location
        for (int i = 0; i < k; i++) {

            int nx = obstacles.get(i).get(0);
            int ny = obstacles.get(i).get(1);

            if (board[nx][ny] != 1) {
                continue;
            }
            int block = getDirection(r_q, c_q, nx, ny, n);

            answer -= block;
            // System.out.println("answer : " + answer);
            // while(nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
            //     if(board[nx][ny] == 1) {
            //         board[nx][ny] = 0;
            //     }
            //     nx = nx + dx[dir];
            //     ny = ny + dy[dir];
            // }
        }
        return answer;
    }

    private static int getDirection(int r_q, int c_q, int nx, int ny, int n) {
        if (r_q == nx) {
            if (c_q < ny) {
                // System.out.println(nx + " - " + ny + " : " + ((n - ny) + 1));
                return (n - ny) + 1;
            } else {
                // System.out.println(nx + " - " + ny + " : " + ny);
                return ny;
            }
        }

        if (c_q == ny) {
            if (r_q < nx) {
                // System.out.println(nx + " - " + ny + " : " + ((n - nx) + 1));
                return (n - nx) + 1;
            } else {
                // System.out.println(nx + " - " + ny + " : " + nx);
                return nx;
            }
        }

        if (r_q < nx) {
            if (c_q < ny) {
                // System.out.println(nx + " - " + ny + " : " + (Math.min(n - ny, n - nx) + 1));
                return Math.min(n - ny, n - nx) + 1;
            } else {
                // System.out.println(nx + " - " + ny + " : " + Math.min((n - nx) + 1, ny));
                return Math.min((n - nx) + 1, ny);
            }
        } else {
            if (c_q < ny) {
                // System.out.println(nx + " - " + ny + " : " + Math.min((n - ny) + 1, nx));
                return Math.min((n - ny) + 1, nx);
            } else {
                // System.out.println(nx + " - " + ny + " : " + Math.min(nx, ny));
                return Math.min(nx, ny);
            }
        }
    }
}
