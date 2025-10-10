package algorithm_study.programers.level2;

import java.util.*;
// 도넛과 막대 그래프 - https://school.programmers.co.kr/learn/courses/30/lessons/258711
public class Pro258711 {
    public int[] solution(int[][] edges) {
        // [생성 정점, 도넛 수, 막대 수, 8자 수]
        int[] answer = new int[4];

        // 1) 인접리스트 + 실제 등장한 노드 집합
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> nodeSet = new HashSet<>();
        int maxId = 0;

        for (int[] e : edges) {
            int from = e[0], to = e[1];
            map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            nodeSet.add(from);
            nodeSet.add(to);
            if (from > maxId) maxId = from;
            if (to > maxId)   maxId = to;
        }

        // 2) 차수 계산 (nodes[i][0]=out, nodes[i][1]=in)
        int[][] nodes = new int[maxId + 1][2];
        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {
            int u = ent.getKey();
            List<Integer> adj = ent.getValue();
            nodes[u][0] += adj.size();        // out-degree
            for (int v : adj) nodes[v][1]++;  // in-degree
        }

        // 3) 생성 정점 찾기: in=0 && out>=2  (실제 등장 노드만 순회!)
        int gen = 0;
        for (int v : nodeSet) {
            if (nodes[v][1] == 0 && nodes[v][0] >= 2) {
                gen = v;
                break;
            }
        }
        answer[0] = gen;

        // 4) 막대/8자 카운트 (실제 등장 노드만, 생성 정점 제외)
        int sticks = 0, eights = 0;
        for (int v : nodeSet) {
            if (v == gen) continue;
            if (nodes[v][0] == 0) sticks++;                     // 막대의 끝점
            if (nodes[v][0] >= 2 && nodes[v][1] >= 2) eights++; // 8자의 중심(생성엣지 들어와도 in>=2 유지)
        }
        answer[2] = sticks;
        answer[3] = eights;

        // 5) 도넛 = 생성정점 out - (막대 + 8자)
        answer[1] = nodes[gen][0] - (sticks + eights);

        return answer;
    }
}
