package algorithm_study.tic.chap13;

import java.util.ArrayList;
import java.util.Scanner;


/*
입력값
2
5 6
0 0 1 0

3
3 4 5
1 0 1 0

6
1 2 3 4 5 6
2 1 1 1
*/
// 연산자 끼워 넣기 .. 너무 어렵게 생각했네...
public class Q19 {

    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int add, sub, mul, div;

    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }

        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        // DFS 메서드 호출
        dfs(1, arr.get(0));

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    public static void dfs(int i, int now) {
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        } else {

            if (add > 0) {
                add -= 1;
                dfs(i + 1, now + arr.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i + 1, now - arr.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, now * arr.get(i));
                mul += 1;
            }
            if (div > 0) {
                div -= 1;
                dfs(i + 1, now / arr.get(i));
                div += 1;
            }
        }
    }
}