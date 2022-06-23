package algorithm_study.tic.chap14;

import java.util.*;

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

// 국영수 문제 정답
public class Q23_ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int m = sc.nextInt();
            students.add(new Student(name, kor, eng, m));
        }

        Collections.sort(students);

        // 정렬된 학생 정보에서 이름만 출력
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i).getName());
        }
    }

}

class Student implements Comparable<Student> {

    private String name;
    private int kor;
    private int eng;
    private int m;

    public Student(String name, int kor, int eng, int m) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.m = m;
    }

    /*
    [ 정렬 기준 ]
    1) 두 번째 원소를 기준으로 내림차순 정렬
    2) 두 번째 원소가 같은 경우, 세 번째 원소를 기준으로 오름차순 정렬
    3) 세 번째 원소가 같은 경우, 네 번째 원소를 기준으로 내림차순 정렬
    4) 네 번째 원소가 같은 경우, 첫 번째 원소를 기준으로 오름차순 정렬
    */

    public String getName() {
        return this.name;
    }

    // 정렬 기준은 '점수가 낮은 순서'
    @Override
    public int compareTo(Student other) {
        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
            return this.name.compareTo(other.name);
        }
        if (this.kor == other.kor && this.eng == other.eng) {
            return Integer.compare(other.m, this.m);
        }
        if (this.kor == other.kor) {
            return Integer.compare(this.eng, other.eng);
        }
        return Integer.compare(other.kor, this.kor);
    }
}
