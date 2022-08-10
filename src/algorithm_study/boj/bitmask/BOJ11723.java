package algorithm_study.boj.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 집합 - https://www.acmicpc.net/problem/11723
public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int x = 0;
        CustomSet set = new CustomSet();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("all")) {
                set.all();
                continue;
            }
            if (input[0].equals("empty")) {
                set.empty();
                continue;
            }
            if (input[0].equals("add")) {
                x = Integer.parseInt(input[1]);
                set.add(x);
                continue;
            }
            if (input[0].equals("remove")) {
                x = Integer.parseInt(input[1]);
                set.remove(x);
                continue;
            }
            if (input[0].equals("check")) {
                x = Integer.parseInt(input[1]);
                set.check(x, sb);
                continue;
            }
            if (input[0].equals("toggle")) {
                x = Integer.parseInt(input[1]);
                set.toggle(x);
                continue;
            }
        }
        System.out.println(sb);
    }
}

class CustomSet {
    private boolean[] set = new boolean[20];

    public void add(int x) {
        this.set[x - 1] = true;
    }

    public void remove(int x) {
        this.set[x - 1] = false;
    }

    public void check(int x, StringBuilder sb) {
        if (set[x - 1]) sb.append(1).append('\n');
        else sb.append(0).append('\n');
    }

    public void toggle(int x) {
        set[x - 1] = set[x - 1] ? false : true;
    }

    public void all() {
        for (int i = 0; i < 20; i++) {
            set[i] = true;
        }
    }

    public void empty() {
        for (int i = 0; i < 20; i++) {
            set[i] = false;
        }
    }
}

// 상위 정답 - https://www.acmicpc.net/source/7002276
class BOJ11723Answer {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 20;
        int m = Integer.parseInt(br.readLine());
        int s = 0;

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            String temp = br.readLine();

            if (temp.startsWith("add")) {
                s = (s | (1 << Integer.parseInt(temp.substring(4)) - 1));
            } else if (temp.startsWith("remove")) {
                s = (s & ~(1 << Integer.parseInt(temp.substring(7)) - 1));
            } else if (temp.startsWith("check")) {

                int result = (s & (1 << Integer.parseInt(temp.substring(6)) - 1));
                if (result == 0) {
                    sb.append("0" + "\n");
                } else {
                    sb.append("1" + "\n");
                }
            } else if (temp.startsWith("toggle")) {
                s = (s ^ (1 << Integer.parseInt(temp.substring(7)) - 1));
            } else if (temp.startsWith("all")) {
                s = (1 << n) - 1;
            } else if (temp.startsWith("empty")) {
                s = 0;
            }
        }
        System.out.println(sb);
    }
}