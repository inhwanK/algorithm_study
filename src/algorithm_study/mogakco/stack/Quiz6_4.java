package algorithm_study.mogakco.stack;

public class Quiz6_4 {
    public static void main(String[] args) {
        validate_brace_pair("{{}}{}");
        validate_brace_pair("{{}");
        validate_brace_pair("{{{}}}");
        validate_brace_pair("}{{{}}}{");
        validate_brace_pair("}{");
    }

    static char[] arrBrace;
    static int top;

    static void validate_brace_pair(String strBrace) {
        top = -1;
        arrBrace = new char[strBrace.length()];

        for (int i = 0; i < strBrace.length(); i++) {
            if (strBrace.charAt(i) == '{') {
                push();
            }

            if (strBrace.charAt(i) == '}' && !isEmpty()) {
                pop();
            }
        }

        if (isEmpty()) {
            System.out.println("유효한 중괄호 쌍입니다.");
        } else {
            System.out.println("유효하지 않은 중괄호 쌍입니다.");
        }
    }

    static boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    static void push() {
        top++;
        arrBrace[top] = '{';
        System.out.println("삽입 : " + arrBrace[top] + " " + top);
    }

    static void pop() {
        System.out.println("추출 : " + arrBrace[top--] + " " + top);
    }
}
