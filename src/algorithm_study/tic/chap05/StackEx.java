package algorithm_study.tic.chap05;

import java.util.Stack;

public class StackEx {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(1);
        stack.push(1);
        stack.push(1);

        System.out.println(stack.size());
        System.out.println(stack.push(2));
        System.out.println(stack.empty());

        System.out.println(stack.contains(1));

    }

}
