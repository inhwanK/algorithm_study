package algorithm_study.mogakco.stack;

import java.util.Scanner;

public class StackEx2 {

    private static int top = -1;
    private static int n;
    private static int[] stack;

    static void push(int item){
        top++;
        stack[top] = item;
    }

    static int pop(){
        return stack[top--];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        stack = new int[n];
        for(int i = 0; i < n;i++){
            push(sc.nextInt());
        }

        for(int i = 0; i < n;i++){
            System.out.print(pop() + " ");
        }

    }

}
