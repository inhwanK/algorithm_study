package algorithm_study.tic.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P180 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            students.add(new Student(name, score));

        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }

    }
}

class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {

        if (this.score == o.getScore()) {
            return 0;
        } else if (this.score > o.getScore()) {
            return 1;
        } else {
            return -1;
        }
    }
}