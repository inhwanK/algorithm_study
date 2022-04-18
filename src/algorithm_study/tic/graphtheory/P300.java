package algorithm_study.tic.graphtheory;

import java.util.Arrays;
import java.util.Scanner;

// 도시 분할 계획 풀이 코드 (못품)
public class P300 {

    static int[] house = new int[100001];
    static Route[] routeArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        routeArr = new Route[m];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            Route route = new Route(a, b, cost);
            routeArr[i] = route;
        }

        Arrays.sort(routeArr);

        for (int i = 0; i < n; i++) {
//            house[i] = routeArr[i+1].getA()
//            routeArr[i + 1].getA();
        }

        for (int i = 0; i < n; i++) {
            house[i] = i;
        }

    }

    static int findParent(int[] house, int x) {
        if (house[x] != x) {
            house[x] = findParent(house, house[x]);
        }
        return house[x];
    }

    static void union(int[] house, int a, int b) {
        a = findParent(house, a);
        b = findParent(house, b);

        if (a < b) {
            house[b] = a;
        } else {
            house[a] = b;
        }
    }

}

class Route implements Comparable<Route> {

    private int a;
    private int b;
    private int cost;

    public Route() {
    }

    public Route(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public int compareTo(Route o) {
        if (this.cost > o.getCost()) {
            return 1;
        } else {
            return -1;
        }

    }
}
