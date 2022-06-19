package algorithm_study.tic.chap13;

import java.util.ArrayList;
import java.util.Scanner;


/*
아니 이걸 나 혼자 풀어냈다고?
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
// 연산자 끼워 넣기
public class Q19 {
    static ArrayList<Operator> memo = new ArrayList<Operator>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] operand = new int[n];
        for (int i = 0; i < n; i++) {
            operand[i] = sc.nextInt();
        }

        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();

        ArrayList<String> operators = new ArrayList<>();
        for (int i = 0; i < plus; i++) {
            operators.add("+");
        }
        for (int i = 0; i < minus; i++) {
            operators.add("-");
        }
        for (int i = 0; i < mul; i++) {
            operators.add("*");
        }
        for (int i = 0; i < div; i++) {
            operators.add("/");
        }


        factorial(memo, operators, new String[n - 1], new boolean[n - 1], 0, n - 1);


        int max = -999999999;
        int min = 999999999;

        for (int i = 0; i < memo.size(); i++) {
            Operator operator = memo.get(i);
            int result = operator.calculate(operand);
            min = Math.min(min, result);
            System.out.println("최솟값 계산 중 > " + min);
        }


        for (int i = 0; i < memo.size(); i++) {
            Operator operator = memo.get(i);
            int result = operator.calculate(operand);
            max = Math.max(max, result);
            System.out.println("최댓값 계산 중 > " + max);
        }


        // 재귀를 써야하나요?
        // 첫 번째 방법, 그냥 반복문 존나 돌려서 최댓값, 최솟값 가져오기
        // 조합 알고리즘이 필요한 거 같음.
        // 생각해보니 조합 알고리즘이 재귀였던 것 같은데?

        // 조합 구현한번 해봅시다 자.

        System.out.println(max);
        System.out.println(min);
    }

    // 메모이제이션 필요하지 않나?
    public static void factorial(ArrayList<Operator> operList, ArrayList<String> operators, String[] out, boolean[] visited, int operatorNum, int r) {
        if (operatorNum == r) {
            Operator operator = new Operator();
            operator.setOperators(out);
            System.out.println(out[0] + " | " + out[1]);
            memo.add(operator);

            for (int i = 0; i < memo.size(); i++) {
                System.out.println(memo.get(i).getOperators()[0]);
            }

            return;
        }
        for (int i = 0; i < operators.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[operatorNum] = operators.get(i);
                factorial(operList, operators, out, visited, operatorNum + 1, r);
                visited[i] = false;
            }
        }
    }
}

class Operator {
    private int result;
    private String[] operators;

    public Operator() {
    }

    public Operator(String[] operators) {
        this.operators = operators;
    }

    public String[] getOperators() {
        return operators;
    }

    public void setOperators(String[] operators) {
        this.operators = operators;
    }

    public int getResult() {
        return result;
    }

    public int calculate(int[] operand) {
        int sum = operand[0];
        for (int i = 0; i < operand.length - 1; i++) {
            if (operators[i].equals("+")) sum += operand[i + 1];
            if (operators[i].equals("-")) sum -= operand[i + 1];
            if (operators[i].equals("*")) sum *= operand[i + 1];
            if (operators[i].equals("/")) {
                if (sum < 0 && operand[i + 1] > 0) {
                    sum = Math.abs(sum);
                    sum /= operand[i + 1];
                    sum = sum * (-1);
                } else {
                    sum /= operand[i + 1];
                }
            }
        }

        this.result = sum;
        return result;
    }
}