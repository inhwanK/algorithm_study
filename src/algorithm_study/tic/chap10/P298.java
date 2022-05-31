package algorithm_study.tic.chap10;

import java.util.Scanner;

// P298 팀 결성 문제 풀이 코드
public class P298 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

//        root 노드 초기화
        int[] teamArr = new int[n + 1];
        for (int i = 1; i < teamArr.length; i++) {
            teamArr[i] = i;
        }

//      값 입력 받은 후 연산
        for (int i = 0; i < m; i++) {
            int oprType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            operator(teamArr, oprType, a, b);
        }

    }

    static void operator(int[] teamArr, int oprType, int a, int b) {

        if (oprType == 0) {
//            팀 합치기
            union(teamArr, a, b);

        } else {
//            같은 팀 여부 확인
            if (teamArr[a] == teamArr[b]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static void union(int[] teamArr, int a, int b) {

        a = findParent(teamArr, a);
        b = findParent(teamArr, b);

        if (a < b) {
            teamArr[b] = a;
        } else {
            teamArr[a] = b;
        }
    }

    static int findParent(int[] teamArr, int x) {
        if (teamArr[x] != x) {
            teamArr[x] = findParent(teamArr, teamArr[x]);
        }
        return teamArr[x];
    }
}
