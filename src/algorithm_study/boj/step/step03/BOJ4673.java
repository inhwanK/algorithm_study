package algorithm_study.boj.step.step03;

// 셀프 넘버 - https://www.acmicpc.net/problem/4673
public class BOJ4673 {
    public static boolean[] arr = new boolean[10001];

    public static void main(String[] args) {
        int n = 1;
        while (n <= 10000) {
            d(n);
            n++;
        }
        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) System.out.println(i);
        }

    }

    // d(n) 함수 구현
    public static void d(int n) {
        n += n % 10 + (n % 100) / 10 + (n % 1000) / 100 + (n % 10000) / 1000;
        if (n > 10000 || arr[n]) return;
        else {
            arr[n] = true;
        }
    }
}

// 상위 정답 - https://www.acmicpc.net/source/17533883
class BOJ4673Answer {
    public static void main(String[] args) {

        boolean[] check = new boolean[10000];

        for (int j = 1; j <= 10000; j++) {
            int n = d(j);
            if (n <= 10000)
                check[n - 1] = true;
        }

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            if (!check[i]) // 생성자가 없으면
                buf.append(i + 1).append("\n");
        }
        System.out.println(buf.toString());
    }

    static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

}