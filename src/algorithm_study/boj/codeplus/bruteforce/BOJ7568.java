package algorithm_study.boj.codeplus.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 덩치 - https://www.acmicpc.net/problem/7568
public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Person[] personArr = new Person[n];

        for (int i = 0; i < n; i++) {
            String[] bulk = br.readLine().split(" ");
            int x = Integer.parseInt(bulk[0]);
            int y = Integer.parseInt(bulk[1]);
            personArr[i] = new Person(x, y);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) personArr[i].compareBulk(personArr[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(personArr[i].getIndex()).append(" ");
        }
        System.out.println(sb);
    }
}

class Person {
    private int x;
    private int y;
    private int index = 1;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void compareBulk(Person other) {
        if (other.getX() > this.x && other.getY() > this.y) index++;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getIndex() {
        return this.index;
    }
}

// 내 풀이와 큰 차이 없음
// 1위 정답 - https://www.acmicpc.net/source/6455079
class BOJ7568Answer {
    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(rd.readLine());
        int[][] size = new int[n][3];

        for(int i = 0;i < n;i++){
            String[] input = rd.readLine().split(" ");
            size[i][0] = Integer.parseInt(input[0]);
            size[i][1] = Integer.parseInt(input[1]);
            size[i][2] = 1;
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i == j){
                    continue;
                }
                if((size[i][0] < size[j][0]) && (size[i][1] < size[j][1])){
                    size[i][2]++;
                }
            }
        }

        for(int i = 0;i<n;i++){
            sb.append(size[i][2]);
            if(i != n-1){
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}