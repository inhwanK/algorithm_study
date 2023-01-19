package algorithm_study.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// 이거 TreeMap 아니면 안됨
// 왤까?
// ATM - https://www.acmicpc.net/problem/11399
public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        // N명의 사람들이 줄서있음, 번호 매겨져 있음
        // i번 사람이 돈 인출하는데 pi분 걸림, 줄서는 순서에 따라 각 사람의 인출 시간이 달라짐
        // 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
        // 그냥 정렬해서 출력하면 됨

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int[] arr = new int[n + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(input[i]);
            arr[i + 1]++;
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        int sum = 0;
        int pre = 0;
        for (Integer key : map.keySet()) {
            for(int i = 0; i < map.get(key); i++) {

                sum += key + pre;
                pre += key;
            }
        }
        System.out.println(sum);
    }
}