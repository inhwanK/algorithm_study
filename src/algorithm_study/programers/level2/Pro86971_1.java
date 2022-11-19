package algorithm_study.programers.level2;

import java.util.*;

// 전력망을 둘로 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/86971
class Pro86971_1 {
    public static boolean[] check;
    public static int[][] network;
    public static int n;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        this.n = n;
        for (int target = 0; target < n - 1; target++) {
            init(target, wires);

            dfs(network[target]);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    count++;
                }
            }

            answer = Math.min(answer, Math.abs((n - count) - count));
        }

        return answer;
    }

    public void init(int target, int[][] wires) {
        check = new boolean[n];
        network = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            int x = wires[i][0] - 1;
            int y = wires[i][1] - 1;

            if (i == target) {
                network[x][x] = 1;
                continue;
            }

            network[x][y] = 1;
            network[y][x] = 1;
        }
    }

    public void dfs(int[] net) {

        for (int i = 0; i < net.length; i++) {
            if (!check[i] && net[i] == 1) {
                check[i] = true;
                dfs(network[i]);
            }
        }
    }
}

class Pro86971Solution_2 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[] check = new boolean[n];
        int[][] network = new int[n][n];

        for (int target = 0; target < n - 1; target++) {
            checkInit(check);

            createNetwork(n, target, network, wires);

            dfs(network[target], check, network);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    count++;
                }
            }
            answer = Math.min(answer, Math.abs((n - count) - count));
        }

        return answer;
    }

    public void checkInit(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            check[i] = false;
        }
    }

    public void createNetwork(int n, int target, int[][] network, int[][] wires) {
        for (int i = 0; i < n - 1; i++) {
            int x = wires[i][0] - 1;
            int y = wires[i][1] - 1;

            network[x][x] = 1;

            network[x][y] = 0;
            network[y][x] = 0;

            if (i != target) {
                network[x][y] = 1;
                network[y][x] = 1;
            }
        }
    }

    public void dfs(int[] net, boolean[] check, int[][] network) {

        for (int i = 0; i < net.length; i++) {
            if (!check[i] && net[i] == 1) {
                check[i] = true;
                dfs(network[i], check, network);
            }
        }
    }
}

class Pro86971Answer_1 {
    int N, min;
    int[][] map;
    int[] vst;

    int dfs(int n) {
        vst[n] = 1; // 빼도 무방함
        int child = 1;
        for (int i = 1; i <= N; i++) {
            if (vst[i] == 0 && map[n][i] == 1) {
                vst[i] = 1;
                child += dfs(i);
            }
        }
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }

    public int solution(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n + 1][n + 1];
        vst = new int[n + 1];
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }
}

class Pro86971Answer_2 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;


        for (int i = 0; i < wires.length; i++) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] union = new int[n + 1];

            for (int j = 1; j < n + 1; j++) {
                union[j] = 1;
                map.put(j, new ArrayList<Integer>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;

                int node1 = wires[j][0];
                int node2 = wires[j][1];

                map.get(node1).add(node2);
                map.get(node2).add(node1);
            }

            recursive(n, map, n, union);

            int p1Count = 0;
            int p2Count = 0;
            for (int j = 1; j < union.length; j++) {
                if (union[j] == 1) p1Count++;
                else p2Count++;
            }

            answer = Math.min(answer, Math.abs(p1Count - p2Count));
        }
        return answer;
    }

    public void recursive(int start, Map<Integer, List<Integer>> map, int parent, int[] union) {
        if (union[start] == parent) return;

        union[start] = parent;

        for (int v : map.get(start)) {
            recursive(v, map, parent, union);
        }


    }
}