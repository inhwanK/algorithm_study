package algorithm_study.programers.level2;
import java.util.*;

// 전력망을 둘로 나누기 - https://school.programmers.co.kr/learn/courses/30/lessons/86971
class Pro86971 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;


        for(int i = 0; i < wires.length; i++){
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] union = new int[n+1];

            for(int j = 1; j < n+1; j++){
                union[j] = 1;
                map.put(j, new ArrayList<Integer>());
            }

            for(int j = 0; j < wires.length; j++){
                if(i == j) continue;

                int node1 = wires[j][0];
                int node2 = wires[j][1];

                map.get(node1).add(node2);
                map.get(node2).add(node1);
            }

            recursive(n, map, n, union);

            int p1Count = 0;
            int p2Count = 0;
            for(int j = 1; j < union.length; j++){
                if(union[j] == 1) p1Count++;
                else p2Count++;
            }

            answer = Math.min(answer, Math.abs(p1Count - p2Count));
        }
        return answer;
    }

    public void recursive(int start, Map<Integer, List<Integer>> map, int parent, int[] union){
        if(union[start] == parent) return;

        union[start] = parent;

        for(int v : map.get(start)){
            recursive(v, map, parent, union);
        }


    }

}