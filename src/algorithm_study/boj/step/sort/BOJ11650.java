package algorithm_study.boj.step.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 좌표 정렬하기 - https://www.acmicpc.net/problem/11650
public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            list.add(new Coordinate(x, y));
        }

        Collections.sort(list);
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).toString());
        }
    }
}

class Coordinate implements Comparable<Coordinate> {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int compareTo(Coordinate other) {
        if (Integer.compare(this.x, other.getX()) != 0) {
            return Integer.compare(this.x, other.getX());
        } else {
            return Integer.compare(this.y, other.getY());
        }
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}

// x에 1000000를 곱하고, y에 100000을 곱해서 정렬이 쉽게 가능하도록 함....
// 상위 정답 - https://www.acmicpc.net/source/13732699
class BOJ11650Answer {
    private static int n, m;
    private static int max = 0;
    private static int[][] map;
    private static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] xy = new long[n];
        long mil = 1000000;
        long thth = 100000;
        for (int i = 0; i < n; ++i ) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            long x = Integer.parseInt(tokenizer.nextToken()) + thth;
            long y = Integer.parseInt(tokenizer.nextToken()) + thth;
            xy[i] = x * mil + y;
        }
        Arrays.sort(xy);
        for (int i = 0; i < n; ++i) {
            bw.write(String.valueOf(xy[i]/mil - thth));
            bw.write(" ");
            bw.write(String.valueOf(xy[i]%mil - thth));
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}