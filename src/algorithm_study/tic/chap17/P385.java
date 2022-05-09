package algorithm_study.tic.chap17;

import java.util.*;

/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
*/
public class P385 {

    static int n, m;
    static int[][] busArr = new int[101][101];
    static final int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            Arrays.fill(busArr[i], INF);
        }

        for (int i = 1; i <= n; i++) {
            busArr[i][i] = 0;
        }

        PriorityQueue<Bus> busHeap = new PriorityQueue(new Bus());
        for (int i = 1; i <= m; i++) {
            Bus bus = new Bus(sc.nextInt(), sc.nextInt(), sc.nextInt());
            busHeap.offer(bus);
        }

        for (int i = 0; i < m; i++) {
            Bus bus = busHeap.poll();
            busArr[bus.getA()][bus.getB()] = Math.min(busArr[bus.getA()][bus.getB()], bus.getCost());
        }
        // 힙을 쓰는 의미가 없음

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    busArr[i][j] = Math.min(busArr[i][j], busArr[i][k] + busArr[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(busArr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class Bus implements Comparator<Bus> {
    private int a;
    private int b;
    private int cost;

    public Bus() {
    }

    public Bus(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compare(Bus o1, Bus o2) {
        return Integer.compare(o1.getCost(), o2.getCost());
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCost() {
        return cost;
    }


    @Override
    public String toString() {
        return "Bus{" +
                "a=" + a +
                ", b=" + b +
                ", cost=" + cost +
                '}';
    }
}
