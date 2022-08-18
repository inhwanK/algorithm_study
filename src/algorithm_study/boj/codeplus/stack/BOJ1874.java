package algorithm_study.boj.codeplus.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://st-lab.tistory.com/182
// 스택 수열 - https://www.acmicpc.net/problem/1874
public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}

class BOJ1874Answer_1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int length = n;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int top = 0;
        int input = 0;
        while (n-- > 0) {
            input = Integer.parseInt(br.readLine());
            if (input > top) {
                while (input >= top + 1) {
                    stack[idx++] = ++top;
                    sb.append("+\n");
                }
            } else if (input < top) {
                if (stack[idx - 1] != input) {
                    System.out.println("NO");
                    return;
                }
            }
            idx--;
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}

class BOJ1874Answer_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();    // 출력할 결과물 저장

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int start = 0;

        // N 번 반복
        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());
            if (value > start) {
                // start + 1부터 입력받은 value 까지 push를 한다.
                for (int i = start + 1; i <= value; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');    // + 를 저장한다.
                }
                start = value;    // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            } else if (stack.peek() != value) {
                // value가 start 값보다 2 이상 차이나면 이후에 수열을 완성할 수 없기 때문에
                // 2 이상 차이나는 경우를 볼필요 없이 바로 NO를 출력
                System.out.println("NO");
                return;        // 또는 System.exit(0); 으로 대체해도 됨.
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}