package algorithm_study.hacker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

// Climbing the Leaderboard - https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
public class ClimbingTheLeaderboard {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        int pre = 0;
        int[][] rank = new int[ranked.size() + 1][2];
        rank[0][0] = 0;
        rank[0][1] = 1000_000_001;
        for (int i = 0; i < ranked.size(); i++) {
            if (pre == ranked.get(i)) {
                rank[i + 1][0] = rank[i][0];
            } else {
                rank[i + 1][0] = rank[i][0] + 1;
                pre = ranked.get(i);
            }

            rank[i + 1][1] = ranked.get(i);
        }


        int[] res = new int[player.size()];
        int rindex = rank.length - 1;

        for (int index = 0; index < player.size(); index++) {
            while (player.get(index) > rank[rindex][1]) {
                rindex--;
            }

            if (player.get(index) == rank[rindex][1]) {
                res[index] = rank[rindex][0];
            } else if (player.get(index) < rank[rindex][1]) {
                res[index] = rank[rindex][0] + 1;
            }
            // System.out.println(index + " " + res[index]);
        }

        List<Integer> result = new ArrayList();
        for (int i = 0; i < res.length; i++) {
            result.add(res[i]);
        }

        return result;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ClimbingTheLeaderboard.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}