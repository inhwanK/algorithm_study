package algorithm_study.tic.chap12;

import java.util.ArrayList;

class Architecture1 implements Comparable<Architecture1> {
    private int x;
    private int y;
    private int stuff;

    public Architecture1(int x, int y, int stuff) {
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStuff() {
        return stuff;
    }

    @Override
    public int compareTo(Architecture1 other) {
        if (this.x == other.x && this.y == other.y) {
            return Integer.compare(this.stuff, other.stuff);
        }
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }

        return Integer.compare(this.x, other.x);
    }
}


public class Q12 {

    public boolean possible(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            if (stuff == 0) { // 기둥의 경우
                boolean check = false;

                if (y == 0) check = false;

                for (int j = 0; j < answer.size(); j++) {

                }
            }

        }


        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        // 현재 설치된 구조물이 '가능한' 구조물인지 확인하기

        // 전체 구조물을 확인하는 메서드

        // 설치 수행한 뒤 전체 구조 확인
        // 구조가 잘 못 되었다면, 다시 삭제

        // 삭제 수행한 뒤 전체 구조 확인
        // 구조가 잘 못 되었다면, 다시 설치


        return answer;
    }
}
