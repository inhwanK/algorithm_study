package algorithm_study.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 이모티콘 - https://www.acmicpc.net/problem/14226
public class BOJ14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[1001][1001];
        visited[1][0] = true;


        Queue<Emoji> que = new LinkedList<>();
        Emoji first = new Emoji(1, 0, 0);
        que.add(first);

        while (!que.isEmpty()) {
            Emoji now = que.poll();
            System.out.println("now > " + now);
            if (now.number == s) {
                System.out.println(now.count);
                break;
            }

            if (!visited[now.number][now.number] && now.check()) {
                Emoji next = now.renewMemo();
                que.add(next);
                visited[now.number][now.memo] = true;
            }
            if (now.memo != 0 && now.number + now.memo < 1001 && !visited[now.number + now.memo][now.memo]) {
                Emoji next = new Emoji(now.number + now.memo, now.count + 1, now.memo);
                que.add(next);
                visited[now.number + now.memo][now.memo] = true;
            }
            if (now.number - 1 > 0 && !visited[now.number - 1][now.memo]) {
                Emoji next = new Emoji(now.number - 1, now.count + 1, now.memo);
                que.add(next);
                visited[now.number - 1][now.memo] = true;
            }
        }
    }


}

class Emoji {
    int number;
    int count;
    int memo;

    public Emoji(int number, int count, int memo) {
        this.number = number;
        this.count = count;
        this.memo = memo;
    }

    public Emoji renewMemo() {
        return new Emoji(number, count + 1, number);
    }

    public boolean check() {
        if (memo == number) {
            return false;
        }
        return true;
    }

    public String toString() {
        return number + " - " + count + " - " + memo;
    }
}
