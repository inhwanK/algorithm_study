package algorithm_study.boj.recursion;

import java.io.*;

public class BOJ17478 {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

        recur(0, "");
    }

    public static void recur(int depth, String under) {
        if (depth == n) {
            System.out.println(under + "\"재귀함수가 뭔가요?\"");
            System.out.println(under + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(under + "라고 답변하였지.");
            return;
        }

        System.out.println(under + "\"재귀함수가 뭔가요?\"");
        System.out.println(under + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(under + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(under + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        recur(depth + 1, under + "____");
        System.out.println(under + "라고 답변하였지.");
    }
}
// 재귀 나랑 너무안맞아 ㅠㅠ
// 상위 정답 - https://www.acmicpc.net/source/16087299
class BOJ17478Answer {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursive(0);
        bw.flush();
    }

    private static void recursive(int num) throws IOException{
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("____");
        }
        bw.write(sb + "\"재귀함수가 뭔가요?\"\n");
        if (num == n) {
            bw.write(sb + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        } else {
            bw.write(sb + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.write(sb + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.write(sb + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            recursive(num + 1);
        }
        bw.write(sb + "라고 답변하였지.\n");
    }
}