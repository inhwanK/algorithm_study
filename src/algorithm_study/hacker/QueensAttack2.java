package algorithm_study.hacker;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QueensAttack2 {
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        HashMap<String, String> map = new HashMap();
        String key = "";
        for(int i = 0; i < k; i++) {
            key = obstacles.get(i).get(0) + "-" + obstacles.get(i).get(1);
            map.put(key, "obstacle");
        }

        int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        int answer = 0;

        // 8 direction check
        for (int dir = 0; dir < 8; dir++) {
            int nx = r_q;
            int ny = c_q;

            while(true) {
                nx = nx + dx[dir];
                ny = ny + dy[dir];

                if(nx < 1 || nx > n || ny < 1 || ny > n) {
                    break;
                }

                String check = nx + "-" + ny;
                if(map.containsKey(check)) {
                    break;
                }
                answer++;
            }
        }
        return answer;
    }
}
