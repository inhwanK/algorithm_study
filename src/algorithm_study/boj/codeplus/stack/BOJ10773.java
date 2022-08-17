package algorithm_study.boj.codeplus.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로 - https://www.acmicpc.net/problem/10773
public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        long sum = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                sum -= stack.pop();
            } else {
                stack.add(temp);
                sum += temp;
            }
        }
        System.out.println(sum);
    }
}

// byte 단위로 읽기 때문에 속도가 빠름, 그러나 실제 코테에서 유효한 느낌은 아닌 듯
// 1위 정답 - https://www.acmicpc.net/source/39037247
class BOJ10773Answer {

    public static void main(String[] args) throws Exception {

        int K = read(), top = -1, num;
        int[] stack = new int[K];

        while (K-- > 0)
            if ((num = read()) == 0) top--;
            else stack[++top] = num;

        while (top > -1) K += stack[top--];

        System.out.print(K + 1);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}