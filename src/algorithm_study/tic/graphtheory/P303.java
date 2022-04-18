package algorithm_study.tic.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 커리큘럼 문제 풀이 코드 (못 품)
public class P303 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            ArrayList<Integer> preLec = new ArrayList<Integer>();
            while (true) {
                Integer num = sc.nextInt();
                if (num == -1) {
                    break;
                } else {
                    preLec.add(num);
                }
            }
        }

    }

}

class Lecture implements Comparable<Lecture> {

    private int number;
    private int time;
    private List<Integer> preLec = new ArrayList<>();

    public Lecture(int number, int time, List<Integer> preLec) {
        this.number = number;
        this.time = time;
        this.preLec = preLec;
    }

    public int getNumber() {
        return number;
    }

    public int getTime() {
        return time;
    }

    public List<Integer> getPreLec() {
        return preLec;
    }

    @Override
    public int compareTo(Lecture o) {

        return 0;
    }
}