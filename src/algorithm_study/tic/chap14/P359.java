package algorithm_study.tic.chap14;

import java.util.*;

// 국영수 문제 풀이

/* 입력값
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Teawhan 50 60 90
 */
public class P359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Score[] scoreArr = new Score[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            scoreArr[i] = new Score(name, korean, english, math);
        }

        Arrays.sort(scoreArr);

        for (int i = 0; i < n; i++) {
            System.out.println(scoreArr[i].name);
        }
    }
}

class Score implements Comparable<Score> {

    String name;
    int korean;
    int english;
    int math;

    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(Score other) {

        if (this.korean == other.korean && this.english == other.english && this.math == other.math) {
            return this.name.compareTo(other.name);
        }
        if (this.korean == other.korean && this.english == other.english) {
            return Integer.compare(other.math, this.math);
        }
        if (this.korean == other.korean) {
            return Integer.compare(this.english, other.english);
        }
        return Integer.compare(other.korean, this.korean);
    }
}